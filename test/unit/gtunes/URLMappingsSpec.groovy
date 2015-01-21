package gtunes

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(com.gtunes.AlbumController)
class URLMappingsSpec extends Specification {

    void testUrlMapping() {
    // assert that /showArtist/Jeff_Beck is handled by the
    // display action in the artist controller

    assertForwardUrlMapping('/showAlbum/Star_Wars',
            controller: 'album', action: 'show')
    }
}
