<html>
<body>
<h1>Please fill all fields to make a reservation</h1>
<form method="get" action="/make-reservation-next">
    Choose hour: <input type="number" name="chosenHour" min="9" max="19" required/>
    <input type="submit" value="proceed to next step"/>
</form>

<form method="get" action="/make-reservation">
    Choose hour: <input type="number" name="status" min="9" max="19" required/>
    <input type="submit" value="check beach status"/>
</form>

<a href=main-menu>Go back to main menu </a>
</body>
</html>