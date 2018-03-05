<html>
<body>
<h1>Please fill all fields to make a reservation</h1>
<form method="post" action="/make-reservation">
    Chose hour: <input type="number" name="chosenHour" min="9" max="19" required/><br/><br/>
    Chose ID: <input type="number" name="chosenId" min="${firstId}" max="${lastId}" required/><br/><br/>
    Chose name: <input type="text" name="chosenName" required/><br/><br/>
    Rent a screen: <input type="checkbox" name="chosenScreen" value="s"/><br/><br/>
    Rent an umbrella: <input type="checkbox" name="chosenUmbrella" value="u"/><br/><br/>
    Rent a towel: <input type="checkbox" name="chosenTowel" value="t"/><br/><br/>
    Rent a sunbed: <input type="checkbox" name="chosenSunbed" value="b"/><br/><br/>
    <input type="submit" name="save" value="make reservation"/><br/><br/>
</form>

<a href=main-menu>Go back to main menu </a>
</body>
</html>