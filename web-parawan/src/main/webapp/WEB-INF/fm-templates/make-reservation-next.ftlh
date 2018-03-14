<#if ((isAlreadyReserved = true)??) >
<div class="alert alert-dismissible alert-warning">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <h4 class="alert-heading">Warning!</h4>
    <p class="mb-0">I'm sorry but the place is already reserved</p>
</div>
</#if>
<#if ((isReserved = true)??) >
    <p>You have successfully reserved a place.</p>

<div class="alert alert-dismissible alert-success">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Well done!</strong> You successfully reserved a place! <a href="/parawan/main-menu" class="alert-link">Go back to main menu.</a>
</div>
</#if>
    <h1>Please fill all fields to make a reservation</h1>
    <form method="post" action="/parawan/make-reservation-next">
        Choose hour: <input type="number" name="chosenHour" value="${hourFromLastStep}" min="9" max="19" required/><br/><br/>
        Choose ID: <input type="number" name="chosenId" value="${idFromLastStep}" min="${firstId}" max="${lastId}" required/><br/><br/>
        Choose name: <input type="text" name="chosenName" required autofocus/><br/><br/>
        Rent a screen: <input type="radio" name="chosenScreen" value="s"/>yes
        <input type="radio" name="chosenScreen" value="z" checked/>no<br/><br/>
        Rent an umbrella: <input type="radio" name="chosenUmbrella" value="u"/>yes
        <input type="radio" name="chosenUmbrella" value="z" checked/>no<br/><br/>
        Rent a Towel: <input type="radio" name="chosenTowel" value="t"/>yes
        <input type="radio" name="chosenTowel" value="z" checked/>no<br/><br/>
        Rent a Sunbed: <input type="radio" name="chosenSunbed" value="b"/>yes
        <input type="radio" name="chosenSunbed" value="z" checked/>no<br/><br/>
        <input type="submit" class="btn btn-primary" name="save" value="make reservation"/><br/><br/>
    </form>





<a href=main-menu>Go back to main menu </a>
