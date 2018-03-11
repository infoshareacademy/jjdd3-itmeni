<html>
<#include "/default/head.html">
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

    <a href=main-menu>Go back to main menu </a>
</div>
<#include "/default/parawan-footer.html">
</body>
</html>

