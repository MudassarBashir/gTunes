package com.gtunes

class GtunesTagLib {
    static defaultEncodeAs = 'html'
    static namespace = 'gt'

    //static encodeAsForTags = [tagName: 'raw']

    def repeat = { attrs, body ->
        // retrieve the 'times' attribute and convert it to an int
        int n = attrs.int('times')
        // render the body 'n' times, passing a 1 based
        // counter into the body each time
        n?.times { counter ->
            out << body(counter + 1)
        }
    }
}
