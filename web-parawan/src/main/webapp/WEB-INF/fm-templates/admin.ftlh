
<div class="row">
    <div class="col-md-6">
        <form method="post" action="/parawan/admin">
            <fieldset>
                <legend>Manage items for rent on: ${actualBeach.name}</legend>
                <div class="form-group">
                    <label for="screen">Screens:</label>
                    <input type="number" class="form-control" id="screen" name="screen">
                </div>
                <div class="form-group">
                    <label for="umbrella">Umbrellas:</label>
                    <input type="number" class="form-control" id="umbrella" name="umbrella">
                    </input>
                </div>
                <div class="form-group">
                    <label for="umbrella">Towels:</label>
                    <input type="number" class="form-control" id="towel" name="towel">
                    </input>
                </div>
                <div class="form-group">
                    <label for="sunbed">Sunbeds:</label>
                    <input type="number" class="form-control" id="sunbed" name="sunbed">
                    </input>
                </div>
                <div class="form-group">
                    <small id="fileHelp" class="form-text text-muted" style="text-align: justify">
                        Remember to double-check that you are on the right beach.
                    </small>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<div class="row">

    <div class="col-md-6">
        <form>
            <fieldset>
                <legend>Add beach</legend>
                <div class="form-group">
                    <label for="beachName">Beach name</label>
                    <input type="email" class="form-control" id="beachName" name="beachName"
                           placeholder="Enter name of new beach">
                </div>

                <div class="form-group">
                    <label for="exampleSelect1">Enter number of places by length</label>
                    <input type="number" class="form-control" id="exampleSelect1">

                    </input>
                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Enter number of places by width</label>
                    <input type="number" class="form-control" id="exampleSelect1">
                    </input>
                </div>

                <div class="form-group">
                    <small id="fileHelp" class="form-text text-muted" style="text-align: justify">
                        Remember to enter all above fields. Please remember not to enter too high values,<br/> better
                        split too big beach to ensure easier administration.
                    </small>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </fieldset>
        </form>
    </div>
</div>