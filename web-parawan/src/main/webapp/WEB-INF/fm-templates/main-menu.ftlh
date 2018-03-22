<div class="row">
    <div class="col-md-2">
        <div class="btn-group-vertical">
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/make-reservation?status=9';">
                Make reservation
            </button>
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/cancel-reservation?status=9';">
                Cancel reservation
            </button>
            <button type="button" class="btn btn-primary" onclick="location.href = '/parawan/find-place?status=9';">Find
                place with additional requirements
            </button>
            <button type="button" class="btn btn-primary"
                    onclick="location.href = '/parawan/item-management?hourFromForm=9';">Items available for rent
            </button>
            <button type="button" class="btn btn-primary" onclick="location.href = '/hello-servlet';">Change beach
            </button>
        </div>
    </div>
    <div class="col-md-10">
        <h1>Hello</h1>
        <p style="text-align: justify">Welcome to our wonderful beaches. You are currently on the ${actualBeach.name}.
            Please choose options on the left panel. If you have any opinion on our services
            please contact us at beaches4everyone@parawan.com . We hope that you will have a great time with us!
        </p>
    </div>
</div>
