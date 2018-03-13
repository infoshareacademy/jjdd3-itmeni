
    <h1>Please fill all fields to make a reservation</h1>
    <p>Beach is open from 9:00 to 19:00</p>
<#if errors??>
    <#list errors>
    <ul>
        <#items as error>
            <li style="color: #ff0000; font-weight: bold; font-size: 14px;">${error}</li>
        </#items>
    </ul>
    </#list>
 <button type="button" class="btn btn-primary" onclick="location.href = '/parawan/make-reservation';">Make reservation</button>
</#if>
    <form method="get" action="/parawan/make-reservation">
        Choose hour: <input type="number" name="status" min="9" max="19" required/>
        <input type="submit" value="check beach status"/>
    </form>
    <br/>
    <div>Legend: <p><span class="unreserved-place"> </span>FREE</p>
        <p>
            <span class="reserved-place"> </span>RESERVED</p></div>
            <table class="table">
                <tbody>

        <#list places as place>
            <#if ((place.id % actualBeach.maxWidth) == 1)>
                <tr>
            </#if>
            <td>
                <button class="btn <#if place.occupied>btn-danger" <#else>btn-success" onclick = location.href="/parawan/make-reservation-next?chosenId=${place.id}&chosenHour=${hour}">


            </#if>
            ${place.id} </td></a>
            </button>
            <#if ((place.id % actualBeach.maxWidth) == 0)> </tr>
            </#if>
        </#list>
                </tbody>
    <br/>
    <a href=main-menu>Go back to main menu </a>
