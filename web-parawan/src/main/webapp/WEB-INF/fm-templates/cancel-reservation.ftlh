<h2>Please fill below to cancel your reservation:</h2>
<p>Beach is open from 9:00 to 19:00</p>
<form method="post" action="/parawan/cancel-reservation">
    Choose ID: <input type="number" name="cancelId" min="${firstId}" max="${lastId}" required/><br/><br/>
    Choose hour: <input type="number" name="cancelHour" min="9" max="19" required/><br/><br/>
    <input type="submit" value="save"/><br/><br/>
</form>
<#if errors??>
    <#list errors>
    <ul>
        <#items as error>
            <li style="color: #ff0000; font-weight: bold; font-size: 14px;">${error}</li>
        </#items>
    </ul>
    </#list>
</#if>


<div>Your reservations on this beach: <br/></div>
<#list reservations as reservation>
    <ul>

        hour: ${reservation.hourOfReservation} place id: ${reservation.placeId}

    </ul>
</#list>

