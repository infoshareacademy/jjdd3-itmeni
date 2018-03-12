<html>
<#include "/default/head.html">
<body>
  <#include "/default/parawan-header.html">
<div class="parawan-body">
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

</#if>
    <form method="get" action="/parawan/make-reservation-next">
        Choose hour: <input type="number" name="chosenHour" min="9" max="19" required/>
        <input type="submit" value="proceed to next step"/>
    </form>

    <form method="get" action="/parawan/make-reservation">
        Choose hour: <input type="number" name="status" min="9" max="19" required/>
        <input type="submit" value="check beach status"/>
    </form>
    <br/>
    <div>Legend: <p><span class="unreserved-place"> </span> FREE</p>
        <p>
            <span class="reserved-place"> </span>RESERVED</p></div>
    <div class="beach-preview">
        <#list places as place>
            <#if (((place.id) % actualBeach.maxWidth) == 1)>
                <div class="row">
            </#if>
                <span class=
            <#if place.occupied>"reserved-place"
            <#else>"unreserved-place"
            </#if>
            >${place.id} </span>
            <#if ((place.id % actualBeach.maxWidth) == 0)> </div>
            </#if>
        </#list>
    </div>
    <br/>
    <a href=main-menu>Go back to main menu </a>
</div>

<#include "/default/parawan-footer.html">
</body>
</html>