<!DOCTYPE html>
<html>
<head>
    <title>Parawan</title>
</head>
<body>
<h1>To cancel your reservation please fill fileds below:</h1>
<form method="post" action="/${action!"cancel-reservation"}">
    Place number (ID): <input type="text" name="cancelId" value="${(user.id)!}"/><br/><br/>
    Hour of yours reservation: <input type="text" name="cancelHour" value="${(user.name)!}"/><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>
</body>
</html>