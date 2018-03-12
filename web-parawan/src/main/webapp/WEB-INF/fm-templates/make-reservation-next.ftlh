<html>
<head>
<#if ((isReserved = true)??) >
    <meta http-equiv="refresh" content="3; url=/parawan/main-menu" />
</#if>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/styles/style.css">
    <title>Paraw@n</title>
</head>
<body>
  <#include "/default/parawan-header.html">
<div class="parawan-body">
    <h1>Please fill all fields to make a reservation</h1>
    <form method="post" action="/parawan/make-reservation-next">
        Choose hour: <input type="number" name="chosenHour" value="${hourFromLastStep}" min="9" max="19" required/><br/><br/>
        Choose ID: <input type="number" name="chosenId" min="${firstId}" max="${lastId}" required/><br/><br/>
        Choose name: <input type="text" name="chosenName" required/><br/><br/>
        Rent a screen: <input type="radio" name="chosenScreen" value="s"/>yes
        <input type="radio" name="chosenScreen" value="z" checked/>no<br/><br/>
        Rent an umbrella: <input type="radio" name="chosenUmbrella" value="u"/>yes
        <input type="radio" name="chosenUmbrella" value="z" checked/>no<br/><br/>
        Rent a Towel: <input type="radio" name="chosenTowel" value="t"/>yes
        <input type="radio" name="chosenTowel" value="z" checked/>no<br/><br/>
        Rent a Sunbed: <input type="radio" name="chosenSunbed" value="b"/>yes
        <input type="radio" name="chosenSunbed" value="z" checked/>no<br/><br/>
        <input type="submit" name="save" value="make reservation"/><br/><br/>
    </form>

 <#if ((isAlreadyReserved = true)??) >
    <p>I'm sorry but the place is already reserved.</p>
 </#if>

 <#if ((isReserved = true)??) >
    <p>You have successfully reserved a place.</p>
 </#if>

<a href=main-menu>Go back to main menu </a>
</div>
<#include "/default/parawan-footer.html">
</body>
</html>

