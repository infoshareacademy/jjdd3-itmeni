<html>
<body>
<h1>Please fill all fields to make a reservation</h1>
<form method="post" action="/make-reservation">
    Hour: <input type="number" name="chosenHour" min="9" max="19" required/><br/><br/>
    ID: <input type="number" name="chosenId" min="1" max="200" required/><br/><br/>
    Name: <input type="text" name="chosenName" required/><br/><br/>
    Screen: <input type="checkbox" name="chosenScreen" value="s"/><br/><br/>
    Umbrella: <input type="checkbox" name="chosenUmbrella" value="u"/><br/><br/>
    Towel: <input type="checkbox" name="chosenTowel" value="t"/><br/><br/>
    Sunbed: <input type="checkbox" name="chosenSunbed" value="b"/><br/><br/>
    <input type="submit" name="save" value="make reservation"/><br/><br/>
</form>

<a href=main-menu>Go back to main menu </a>
</body>
</html>