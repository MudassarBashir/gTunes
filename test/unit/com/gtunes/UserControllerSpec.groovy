package com.gtunes

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock(User)
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void testPasswordsDoNotMatch() {
        given:
            request.method = 'POST'

            params.login = 'henry'
            params.password = 'password'
            params.confirm = 'wrongPassword'
            params.firstName = 'Henry'
            params.lastName = 'Rollins'
        when:
            def model = controller.register()
            def user = model.user
        then:
            user.hasErrors()
            'user.password.dontmatch' == user.errors['password'].code
    }

    void testRegistrationFailed() {
        given:
            request.method = 'POST'

            params.login = ' '

            def model = controller.register()
            def user = model.user
        expect:
            assert user.hasErrors()
            assert session.user == null
            assert 'nullable' == user.errors['login'].code
            assert 'nullable' == user.errors['firstName'].code
            assert 'nullable' == user.errors['lastName'].code
    }

    void testRegistrationSuccess() {
        when: 'These parameters are fed in'
        request.method = 'POST'

        params.login = 'henry'
        params.password = 'password'
        params.confirm = 'password'
        params.firstName = 'Henry'
        params.lastName = 'Rollins'

        controller.register()
        then: 'These statements should pass'
        assert '/store' == response.redirectedUrl
        assert session.user != null
    }

    void testLoginUserNotFound() {
        when:
            request.method = 'POST'

            params.login = 'frank'
            params.password = 'hotrats'

            controller.login()
            def cmd = model.loginCmd
        then:
            assert cmd.hasErrors()
            assert 'user.not.found' == cmd.errors['login'].code
            assert session.user == null
            assert '/store/index' == view
    }

    void testLoginFailurePasswordInvalid() {
        when:
            request.method = 'POST'

            def u = new User(login: 'maynard',
                    firstName: 'Maynard',
                    lastName: 'Keenan',
                    password: 'undertow').save()
            assert u != null

            params.login = 'maynard'
            params.password = 'lateralus'

            controller.login()
            def cmd = model.loginCmd
        then:
            assert cmd.hasErrors()
            assert 'user.password.invalid' == cmd.errors['password'].code
            assert session.user == null
            assert '/store/index' == view
    }

    void testLoginSuccess() {
        when:
            request.method = 'POST'

            def u = new User(login: 'maynard',
                    firstName: 'Maynard',
                    lastName: 'Keenan',
                    password: 'undertow').save()
            assert u != null

            params.login = 'maynard'
            params.password = 'undertow'

            controller.login()
        then:
            assert session.user != null
            assert '/store' == response.redirectedUrl
    }

}
