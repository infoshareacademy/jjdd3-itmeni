<!DOCTYPE html>
<html>
  <body>
    <p>Number of items available for rent</p>

    <form method="get" action="/item-management">
        Hour: <input type="number" name="hourFromForm" min="9" max="19" required/><br/><br/>
        <input type="submit" name="save" value="check items"/><br/><br/>
    </form>

    <#if (hour > 8 && hour <19) >

    <p>Screens: ${items[0]} available for rent</p>
    <p>Umbrellas: ${items[1]} available for rent</p>
    <p>Towels: ${items[2]} available for rent</p>
    <p>sunbeds: ${items[3]} available for rent</p>

    </#if>

    <p><a href=main-menu >Go back to main menu </a></p>
  </body>
</html>