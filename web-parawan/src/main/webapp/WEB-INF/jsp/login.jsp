<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="86269751570-nb846bjukni7ketkbb4li62q6o1lt3kk.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
</head>

<body>
<div id="my-signin2"></div>
<script>



    auth2 = gapi.load(auth2.init)({
        client_id: '86269751570-nb846bjukni7ketkbb4li62q6o1lt3kk.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        scope: 'profile' });

    if (auth2.isSignedIn.get()) {
        var profile = auth2.currentUser.get().getBasicProfile();
        console.log('ID: ' + profile.getId());
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
    }


    function onSuccess(googleUser) {
        console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
        console.log('User email address is: ' + googleUser.getBasicProfile().getEmail());
        console.log('User ID: ' + googleUser.getBasicProfile().getId());
    }

    function onFailure(error) {
        console.log(error);
    }

    function renderButton() {
        gapi.signin2.render('my-signin2', {
            'scope': 'profile email',
            'width': 240,
            'height': 50,
            'longtitle': true,
            'theme': 'dark',
            'onsuccess': onSuccess,
            'onfailure': onFailure
        });
    }
</script>
<div>
    <a href="#" onclick="signOut();">Sign out</a>
    <script>
        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });
        }

    </script>
</div>
</body>
</html>