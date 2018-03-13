
<div class="parawan-body">
    <p>Find place with additional requirements</p>
    <form method="post" action="/parawan/find-place">
        Chose Hour: <input type="number" name="chosenHour" min="9" max="19" required/><br/><br/>
        Do You want no neighbours around?: <input type="radio" name="noNeighbours" value="y"/>yes
        <input type="radio" name="noNeighbours" value="n" checked/>no<br/><br/>
        Do You want no screens around?: <input type="radio" name="noScreens" value="y"/>yes
        <input type="radio" name="noScreens" value="n" checked/>no<br/><br/>
        Do You want no umbrella around?: <input type="radio" name="noUmbrella" value="y"/>yes
        <input type="radio" name="noUmbrella" value="n" checked/>no<br/><br/>
        <input type="submit" name="save" value="search place"/><br/><br/>
    </form>
    <p><a href=main-menu>Go back to main menu </a></p>
