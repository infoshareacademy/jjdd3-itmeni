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
                <a href=make-reservation?chosenHour=0>Make reservation </a>
            </li>
            <li>
                <a href=cancel-reservation>Cancel reservation </a>
            </li>
            <li>
                <a href=find-place>Find place with additional requirements </a>
            </li>
            <li>
                <a href=item-management?hourFromForm=0>Number of items available for rent </a>
            </li>
        </ul>
    </nav>

    <p><a href=../hello-servlet>Go back to intro page </a></p>

    <p>-------------------------------------------------</p>
    <p>Random data generator</p>
    <form action="/generaterandomdata">
        <input type="submit" value="Generate random data"/>
    </form>
    <p>-------------------------------------------------</p>

    <p>Add new beach</p>
    <form action="/addnewbeach">
        Type name: <input type="text" name="nameofbeach" value=""><br/>
        Type width: <input type="text" name="width" value=""><br/>
        type height: <input type="text" name="height" value=""><br/><br/>
        <input type="submit"><br/>
    </form>
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