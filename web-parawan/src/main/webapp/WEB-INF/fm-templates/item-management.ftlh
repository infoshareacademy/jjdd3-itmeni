
<p>Number of items available for rent.</p>
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

<form method="get" action="/parawan/item-management">
    Choose hour: <input type="number" name="hourFromForm" min="9" max="19" required/><br/><br/>
    <input type="submit" value="check items"/><br/><br/>
</form>

      <#if (hour > 8 && hour <=19) >
        <p>At ${hour}:00 we have:</p>
        <p>Screens: ${(items[0])! "Nothing found in database what could be "} available for rent</p>
        <p>Umbrellas: ${(items[1])! "Nothing found in database what could be "}  available for rent</p>
        <p>Towels: ${(items[2])! "Nothing found in database what could be "}  available for rent</p>
        <p>sunbeds: ${(items[3])! "Nothing found in database what could be"}  available for rent</p>

      </#if>

<p><a href=main-menu>Go back to main menu </a></p>
