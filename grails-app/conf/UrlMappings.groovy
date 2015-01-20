class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		 //"/"(view:"/index")
		 /* Moe: Replaced line above with line below as part of gTunes application
		 to make the 'Store' controller our default starting homepage. */
 		"/"(controller:'store')

        /**
         * Moe: Added line below as part of chapter 6 URL Mappings testing.
         */
        "/showArtist/$artistName" (controller:'artist', action:'display')

        "500"(view:'/error')
	}
}