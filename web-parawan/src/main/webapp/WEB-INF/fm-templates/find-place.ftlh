<!DOCTYPE html>
<html>
  <body>
    <p>Find place with additional requirements</p>
    <form method="post" action="/find-place">
        Chose Hour: <input type="number" name="chosenHour" min="9" max="19" required/><br/><br/>
        Do You want no neighbours around?: <input type="radio" name="noNeighbours" value="y"/>yes
         <input type="radio" name="noNeighbours" value="n"/>no<br/><br/>
        Do You want no screens around?: <input type="radio" name="noScreens" value="y"/>yes
        <input type="radio" name="noScreens" value="n"/>no<br/><br/>
        Do You want no umbrella around?: <input type="radio" name="noUmbrella" value="y"/>yes
      <input type="radio" name="noUmbrella" value="n"/>no<br/><br/>
        <input type="submit" name="save" value="search place"/><br/><br/>
    </form>
    <p><a href=main-menu >Go back to main menu </a></p>
  </body>
</html>