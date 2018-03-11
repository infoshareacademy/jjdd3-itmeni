<!DOCTYPE html>
<html>
<#include "/default/head.html">
<body>
  <#include "/default/parawan-header.html">
<div class="parawan-body">
    <h2>Please fill below to cancel your reservation:</h2>
    <form method="post" action="/cancel-reservation">
        Choose ID: <input type="number" name="cancelId" value="${(user.id)!}" min="1" max="200" required/><br/><br/>
        Choose hour: <input type="number" name="cancelHour" value="${(user.name)!}" min="9" max="19"
                            required/><br/><br/>
        <input type="submit" name="save" value="save"/><br/><br/>
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
<#include "/default/parawan-footer.html">
</body>
</html>