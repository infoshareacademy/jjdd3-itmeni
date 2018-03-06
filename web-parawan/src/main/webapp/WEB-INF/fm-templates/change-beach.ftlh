<html>
<body>
<h1>Actual choosen beach is: ${actualBeach.name}</h1>
<h2>Choose beach:</h2>
<form method="post" action="/change-beach">
    <#list beaches as beach>
        <input type="radio" name="beach" value="${beach.id}"> ${beach.name}<br>
    </#list>
    <input type ="submit" name="Choose beach">
</form>

<a href=main-menu>Go back to main menu </a>
</body>
</html>