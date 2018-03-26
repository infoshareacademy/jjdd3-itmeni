<div class="row">
    <div class="col-md-4">
        <div class="btn-group-vertical">
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/make-reservation?status=9';">
                Make reservation
            </button>
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/cancel-reservation?status=9';">
                Cancel reservation
            </button>
            <button type="button" class="btn btn-primary" onclick="location.href = '/parawan/advanced-search?status=9';">Find
                place with additional requirements
            </button>
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/item-management?hourFromForm=9';">Items available for rent
            </button>
            <button type="button" class="btn btn-primary" onclick="location.href = '/parawan/switch-beach';">Switch beach
            </button>
            <#if (userSession.admin == true)>
            <button type="button" class="btn btn-primary" onclick="location.href = '/parawan/admin';">Admin options
            </button>
            </#if>
        </div>
    </div>
    <div class="col-md-8">
        <div>
            <br/>
            <h2>Hello ${(userSession.email)!""}</h2>
            Welcome to our wonderful beaches. You are currently on the ${(actualBeach.name)! "definitly not any beach"}.</br>
            Please choose option from the left panel.</br>
            If you have any opinion on our services please contact us at beaches4everyone@parawan.com.</br>
            We hope that you will have a great time with us!</br>
        </div>
    </div>
</div>
