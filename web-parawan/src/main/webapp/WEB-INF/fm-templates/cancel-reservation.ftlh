<div class="row">
    <div class="col">
    <h3>Please fill below to cancel your reservation:</h3>
    </div>
</div>
<div class="row">
    <div class="col">
    <p>Remember that you can only cancel your reservations!</p>
    </div>
</div>
<div class="row">
    <div class="col">
    <form method="post" action="/parawan/cancel-reservation">
        Choose ID: <input type="number" name="cancelId" min="${firstId}" max="${lastId}" required/><br/><br/>
        Choose hour: <input type="number" name="cancelHour" min="9" max="19" required/><br/><br/>
        <input type="submit" class="btn btn-primary" value="Cancel reservation"/><br/><br/>
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
    </div>
</div>

<div>Your reservations on this beach: <br/></div>
<div class="row">
    <div class="col-md-4">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Hour of reservation</th>
                <th scope="col">Id of reserved place</th>
            </tr>
            </thead>
            <#list reservations as reservation>
                <tr>
                    <td>${reservation.hourOfReservation}</td>
                    <td>${reservation.placeId}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>