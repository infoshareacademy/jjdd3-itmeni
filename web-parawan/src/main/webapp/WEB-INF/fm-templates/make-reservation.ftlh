<html>
<#include "/default/head.html">
<body>
  <#include "/default/parawan-header.html">
<div class="parawan-body">
    <h1>Please fill all fields to make a reservation</h1>
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
        Choose hour: <input type="text" name="chosenHour"/>
        <input type="submit" value="proceed to next step"/>
    </form>

    <form method="get" action="/parawan/make-reservation">
        Choose hour: <input type="number" name="status" min="9" max="19" required/>
        <input type="submit" value="check beach status"/>
    </form>
    <a href=main-menu>Go back to main menu </a>
    <div>
        <#if places??>
        <#list places as place>
            <div class="single-place">${(place.id)! ""} </div>
            <#if place.id % actualBeach.maxWidth>
            <br/>
            </#if>
        </#list>
        <#else > ""
        </#if>
    </div>

</div>
<#include "/default/parawan-footer.html">
</body>
</html>