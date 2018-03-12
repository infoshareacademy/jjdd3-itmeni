<!DOCTYPE html>
<html>
<#include "/default/head.html">
<body>
    <#include "/default/parawan-header.html">
<div class="parawan-body">
    <p>Main Menu</p>

    <nav>
      <ul>
        <li>
          <a href=make-reservation?status=9>Make reservation </a>
        </li>
        <li>
          <a href=cancel-reservation>Cancel reservation </a>
        </li>
        <li>
          <a href=find-place>Find place with additional requirements </a>
        </li>
        <li>
          <a href=item-management?hourFromForm=9>Number of items available for rent  </a>
        </li>
      </ul>
    </nav>

    <p><a href=../hello-servlet>Go back to intro page </a></p>

    <p>-------------------------------------------------</p>

    <p>-------------------------------------------------</p>

    <p>-------------------------------------------------</p>
    <br/>
    <br/>
    <br/>

    <p>List of all reservations</p>
    <form action="/parawan/reservationsfromgivenhour">
        Choose hour: <input type="number" name="hour" min="9" max="19" required>
        <input type="submit">
    </form>
</div>
<#include "/default/parawan-footer.html">
</body>
</html>