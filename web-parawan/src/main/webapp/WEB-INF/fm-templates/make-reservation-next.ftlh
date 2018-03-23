<#if ((isAlreadyReserved == true)??) >
<div class="alert alert-dismissible alert-warning">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <h4 class="alert-heading">Warning!</h4>
    <p class="mb-0">I'm sorry but the place is already reserved</p>
</div>
</#if>
<#if ((itemNotAvailable == true)??) >
<div class="alert alert-dismissible alert-warning">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <h4 class="alert-heading">Warning!</h4>
    <p class="mb-0">I'm sorry but ordered item/s are not available</p>
</div>
</#if>
<#if ((isReserved == true)??) >
<div class="alert alert-dismissible alert-success">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Great!</strong> You successfully reserved a place! <a href="/parawan/main-menu" class="alert-link">Go
    back to main menu.</a>
</div>
</#if>
    <h1>Please fill all fields to make a reservation</h1>
<div class="row">
    <div class="col-md-2">
        <form method="post" action="/parawan/make-reservation-next">
            Choose hour: <input type="number" name="chosenHour" value="${hourFromLastStep}" min="9" max="19"
                                required/><br/><br/>
            Choose ID: <input type="number" name="chosenId" value="${idFromLastStep}" min="${firstId}" max="${lastId}"
                              required/><br/><br/>
            Reserving as: <br/><b>${userSession.email}<b/><br/><br/>
            Rent a screen:<br/><label><input type="radio" name="chosenScreen" value="s"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenScreen" value="z" checked/>&nbsp;no</label><br/><br/>
            Rent an umbrella:<br/>  <label><input type="radio" name="chosenUmbrella" value="u"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenUmbrella" value="z" checked/>&nbsp;no</label><br/><br/>
            Rent a Towel:<br/>  <label><input type="radio" name="chosenTowel" value="t"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenTowel" value="z" checked/>&nbsp;no</label><br/><br/>
            Rent a Sunbed:<br/>  <label><input type="radio" name="chosenSunbed" value="b"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenSunbed" value="z" checked/>&nbsp;no</label><br/><br/>
            <input type="submit" class="btn btn-primary" name="save" value="make reservation"/><br/><br/>
        </form>
    </div>
    <div class="col-md-10">
        <table class="table">
            <tbody>
        <#list places as place>
            <#if ((place.id % actualBeach.maxWidth) == 1)>
                <tr>
            </#if>
            <td>
               <button type="button" class="btn btn-block
                    <#if (place.id == idFromLastStep)>
                            btn-info">
                    <#elseif place.occupied>btn-danger">
                    <#else>btn-success" onclick="location.href = '/parawan/make-reservation-next?chosenId=${place.id}&chosenHour=${hour}';">
                    </#if>
                    ${place.id}
                </button>
            </td>
            <#if ((place.id % actualBeach.maxWidth) == 0)> </tr>
            </#if>
        </#list>
            </tbody>
        </table>
    </div>
</div>
