<%@ page import="com.gtunes.Song" %>



<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="song.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${songInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'artist', 'error')} required">
	<label for="artist">
		<g:message code="song.artist.label" default="Artist" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="artist" required="" value="${songInstance?.artist}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'album', 'error')} required">
	<label for="album">
		<g:message code="song.album.label" default="Album" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="album" name="album.id" from="${com.gtunes.Album.list()}" optionKey="id" required="" value="${songInstance?.album?.id}" class="many-to-one"/>

</div>

