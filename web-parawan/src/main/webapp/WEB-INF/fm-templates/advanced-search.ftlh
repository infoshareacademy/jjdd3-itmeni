<div class="row">
    <div class="col-md-2">
        <form method="post" action="/parawan/advanced-search">
            Choose hour: <input type="number" name="chosenHour" value="${(chosenHour)! ""}" min="9" max="19"
                                required/><br/><br/>
            Would you like to:</br>
            see places with rented screens?<br/><label><input type="radio" name="screen" value="s"/>&nbsp;yes</label>
            <label><input type="radio" name="screen" value="z" checked/>&nbsp;no</label><br/>
            see places with rented umbrellas?<br/>  <label><input type="radio" name="umbrella" value="u"/>&nbsp;yes</label>
            <label><input type="radio" name="umbrella" value="z" checked/>&nbsp;no</label><br/><br/>
            <input type="submit" class="btn btn-primary" name="save" value="Check"/><br/><br/>
        </form>
        Legend:
        <p>
            <button class="btn btn-success btn-block">FREE</button>
        </p>
        <p>
            <button class="btn btn-danger btn-block">RESERVED</button>
        </p>
        <p>
            <button class="btn btn-primary btn-block">HAS RENTED ITEMS</button>
        </p>
        <p>
            Click a place to proceed.
        </p>
    </div>

    <div class="col-md-10">

        <table class="table">
            <tbody>
        <#list listOfPlaces as place>
            <#if ((place.id % actualBeach.maxWidth) == 1)>
                <tr>
            </#if>
            <td>
                <button type="button" class="btn btn-block
                    <#if (place.meetsSearchCriteria)>btn-primary">
                    <#elseif (place.occupied)>btn-danger">
                    <#else>btn-success" onclick="location.href = '/parawan/make-reservation-next?chosenId=${place.id}&chosenHour=${chosenHour}';">
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