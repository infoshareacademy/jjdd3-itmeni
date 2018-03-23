<div class="row">
    <div class="col-md-5">
        <form method="post" action="/log-in">
            <fieldset>
                Email:<br/>
                <input type="email" class="form-control" name="email"><br/>
                Password:<br/>
                <input type="password" class="form-control" name="password"><br/>
                <input type="submit" class="btn btn-primary" value="Log in!">
            </fieldset>
        </form>
    </div>
</div>
<br/>
<br/>
<p> Actual beach: ${(actualBeach.name)! "EMPTY DATABASE, application is not ready for work, please contact administrator"}</p>
         <h2>Switch beach:</h2>
         <form method="post" action="/parawan/change-beach">
             <fieldset>
    <#list beaches as beach>
    <label>
        <input type="radio" name="beach" value="${beach.id}" required checked style="font-size: 1.5em"> ${beach.name}
    </label>
    <br/><br/>
    </#list>
                 <input type="submit" class="btn btn-primary" name="Choose beach" value="Choose beach">
             </fieldset>
         </form>
