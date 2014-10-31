
<%@ page import="com.gtunes.Song" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'song.label', default: 'Song')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-song" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-song" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'song.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="artist" title="${message(code: 'song.artist.label', default: 'Artist')}" />
					
						<th><g:message code="song.album.label" default="Album" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${songInstanceList}" status="i" var="songInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${songInstance.id}">${fieldValue(bean: songInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: songInstance, field: "artist")}</td>
					
						<td>${fieldValue(bean: songInstance, field: "album")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${songInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
