<#if ((updatedItems == true)??) >
<div class="alert alert-dismissible alert-success">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Great!</strong> You successfully updated items on ${actualBeach.name} <a href="/parawan/main-menu" class="alert-link">Go
    back to main menu.</a>
</div>
</#if>
<#if ((createdBeach == true)??) >
<div class="alert alert-dismissible alert-success">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Great!</strong> You successfully created a new beach <a href="/parawan/change-beach" class="alert-link">Go
    back to welcome screen to change to new beach.</a>
</div>
</#if>
<#if ((isReserved == true)??) >
<div class="alert alert-dismissible alert-success">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Great!</strong> You successfully reserved a place! <a href="/parawan/main-menu" class="alert-link">Go
    back to main menu.</a>
</div>
</#if>
<div class="row">
    <div class="col-md-5">
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
<br/>
<br/>
<div class="row">
    <div class="col-md-5">
        <form method="post" action="/parawan/admin/createbeach">
            <fieldset>
                <legend>Add beach</legend>
                <div class="form-group">
                    <label for="beachName">Beach name</label>
                    <input type="text" class="form-control" id="beachName" name="beachName"
                           placeholder="Enter name of new beach">
                </div>
                <div class="form-group">
                    <label for="beachX">Enter number of places by length</label>
                    <input type="number" class="form-control" id="beachLength" name="beachX">
                    </input>
                </div>
                <div class="form-group">
                    <label for="beachY">Enter number of places by width</label>
                    <input type="number" class="form-control" id="beachY" name="beachY">
                    </input>
                </div>
                <div class="form-group">
                    <small id="fileHelp" class="form-text text-muted" style="text-align: justify">
                        Remember to enter all above fields. Please remember not to enter too high values,<br/> better
                        split too big beach to ensure easier administration.
                    </small>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </fieldset>
        </form>
    </div>
</div>