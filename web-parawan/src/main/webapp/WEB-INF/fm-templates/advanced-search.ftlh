<div class="row">
    <div class="col-md-2">
        <form method="post" action="/parawan/advanced-search">
            Choose hour: <input type="number" name="chosenHour" value="" min="9" max="19"
                                required/><br/><br/>
            Show places witch screens:<br/><label><input type="radio" name="chosenScreen" value="s"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenScreen" value="z" checked/>&nbsp;no</label><br/><br/>
            Show places with umbrellas:<br/>  <label><input type="radio" name="chosenUmbrella" value="u"/>&nbsp;yes</label>
            <label><input type="radio" name="chosenUmbrella" value="z" checked/>&nbsp;no</label><br/><br/>
            <input type="submit" class="btn btn-primary" name="save" value="Check"/><br/><br/>
        </form>
    </div>

    <div class="col-md-10">
            <#if ((isAlreadyReserved == true)??) >
        <table class="table">
            <tbody>
        <#list places as place>
            <#if ((place.id % actualBeach.maxWidth) == 1)>
                <tr>
            </#if>
            <td>
                <button type="button" class="btn btn-block
                    <#if place.meetSearchCriteria>btn-danger">
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
            </#if>
    </div>
</div>