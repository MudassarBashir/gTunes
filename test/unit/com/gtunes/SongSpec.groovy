package com.gtunes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Song)
class SongSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void testMinimumDuration() {
        // set the Song class up for constraints testing . . .
        when:
            mockForConstraintsTests Song
            // create a new Song
            def song = new Song(title: 'Some Title',
                    artist: 'Some Artist',
                    duration: 0)
        then:
            // make sure that validation fails . . .
            assert !song.validate()
            // make sure that the 'min' constraint failed . . .
            assert 'min' == song.errors['duration']
    }
}
