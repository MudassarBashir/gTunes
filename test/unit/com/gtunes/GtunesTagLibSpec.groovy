package com.gtunes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(GtunesTagLib)
class GtunesTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test repeat tag"() {
        given:
            // define a snippet of markup to evaluate
            def template = '<gt:repeat times="3">Number ${it}</gt:repeat>'
        when:
            // evaluate the snippet
            def result = applyTemplate(template)
        then:
            // make sure the result contains what we expect
            def expected = 'Number 1Number 2Number 3'
            assert expected == result
    }

    void "test repeat tag with model"() {
        given:
            // define a snippet of markup to evaluate
            def template =
                    '<gt:repeat times="${someNumber}">Number ${it}</gt:repeat>'
        when:
            // evaluate the snippet
            def result = applyTemplate(template, [someNumber: 2])
        then:
            // make sure the result contains what we expect
            def expected = 'Number 1Number 2'
            assert expected == result
        when:
        // evaluate the snippet
        def result2 = applyTemplate(template, [someNumber: 4])
        then:
        // make sure the result contains what we expect
        def expected2 = 'Number 1Number 2Number 3Number 4'
        assert expected2 == result2
    }
}
