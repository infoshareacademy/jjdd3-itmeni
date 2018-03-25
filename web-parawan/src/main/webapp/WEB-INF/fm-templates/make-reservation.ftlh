<p>Beach is open from 9:00 to 19:00</p>
    <div class="row">
        <div class="col-md-3">
        <#if errors??>
            <#list errors>
    <ul>
        <#items as error>
            <li style="color: #ff0000; font-weight: bold; font-size: 14px;">${error}</li>
        </#items>
    </ul>

            </#list>
        </#if>
            <form method="get" action="/parawan/make-reservation">
                Choose hour: <input type="number" name="status" min="9" max="19" value="${(hour)!}" required/>
                <input type="submit" class="btn btn-primary" value="check beach status"/>
            </form>
            <br/>
            Legend:
                <p>
                    <button class="btn btn-success btn-block">FREE</button>
                </p>
                <p>
                    <button class="btn btn-danger btn-block">RESERVED</button>
                </p>
            <p>
                Click a place to proceed.
            </p>
        </div>
            <div class="col-md-9">
                <table class="table">
                    <tbody>

        <#list places as place>
            <#if ((place.id % actualBeach.maxWidth) == 1)>
                <tr>
            </#if>
            <td>
                <button type="button" class="btn btn-block
                    <#if place.occupied>btn-danger">
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
                <div class="btn btn-block btn-info">SEA</div>
            </div>
        </div>
    </div>