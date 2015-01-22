<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="layout" content="main">
    <title>gTunes Welcome</title>
    <g:javascript library="jquery"></g:javascript>
</head>
<body>
    <div class="message notice">
        <h1>Your online music store and storage service!</h1>
        <p>Manage your own library, browse music and purchase new tracks as they become available</p>
        <g:link action="showTime" elementId="timeLink">Show the time!</g:link>
        <div id="time">
        </div>
        <r:script>
            $('#timeLink').click(function() {
                $('#time').load(this.href); return false;
            });
        </r:script>
        <r:script>
            $(function() {
                $('#loginForm').ajaxForm(function(result) {
                    $('#loginBox').html(result);
                });
            });
        </r:script>
    </div>
    <g:if test="${!session?.user}">

        <div class="colset clearfix">
            <div class="left">
                <h1>Need an account?</h1>
                <p class="legend"><g:link controller="user" action="register">Signup now</g:link> to start your own personal Music collection!</p>
                <g:link controller="user" action="register" class="btn">Signup now</g:link>
            </div>
            <div class="right">
                <h1>Already a member?</h1>
                <g:render template="/user/loginBox"/>
            </div>
        </div>

    </g:if>

</body>
</html>
