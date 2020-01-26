<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="assets/css/style.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
</head>
<body>

	<h1>Registration Form</h1>

	<form method="POST" action="/add-new">
		<input type="hidden" id="id" />
		<table>
			<caption></caption>
			<tr>
				<th scope="col"><label for="firstname">Firstname: </label></th>
				<th scope="col"><input name="firstname" maxLength="30" /></th>
			</tr>

			<tr>
				<td><label for="lastname">Lastname: </label></td>
				<td><input name="lastname" maxLength="30" /></td>
			</tr>

			<tr>
				<td colspan="3">
					<button type="submit">Submit</button>
					<button type="reset">Reset</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>