<!DOCTYPE html>
<html>
<#include "/default/head.html">
<body>
  <#include "/default/parawan-header.html">
<div class="parawan-body">
    <p> Actual beach: ${(actualBeach.name)! "EMPTY DATABASE"}</p>
    <h2>Switch beach:</h2>
    <form method="post" action="/parawan/change-beach">
    <#list beaches as beach>
        <input type="radio" name="beach" value="${beach.id}"> ${beach.name}<br>
    </#list>
        <input type="submit" name="Choose beach">
    </form>
    <p><a href=parawan/main-menu>Move on to main menu </a></p>

</div>
<#include "/default/parawan-footer.html">
</body>

</html>