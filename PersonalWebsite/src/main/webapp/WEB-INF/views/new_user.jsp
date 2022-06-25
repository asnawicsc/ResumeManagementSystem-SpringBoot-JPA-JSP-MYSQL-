
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<%@include file="header.jsp"%>
</head>

<body>


	<section>
		<div></div>
		<div class="card">
			<div class="card-body">

				<form action="/createUser" method="post">
					<div class='loginForm'>
						<h1>New User Info</h1>
						<br>
						<div class="form-floating mb-3">
							<input type="number" class="form-control" autofocus
								id="personal_id" name="personal_id"> <label
								for="personal_id">SAP ID</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="first_name"
								name="first_name"> <label for="first_name">First
								Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="last_name"
								name="last_name"> <label for="last_name">Last
								Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="address"
								name="address"> <label for="address">Address</label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" class="form-control" id="age" name="age">
							<label for="age">Age</label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" class="form-control" id="phone_number"
								name="phone_number"> <label for="phone_number">Phone
								Number</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="email" name="email">
							<label for="email">Email</label>
						</div>

						<br>
						<button type="submit" class="btn btn-outline-success">Submit</button>

					</div>
				</form>


				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
					crossorigin="anonymous"></script>

				<!-- Option 2: Separate Popper and Bootstrap JS -->

				<script
					src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
					integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
					crossorigin="anonymous"></script>
				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
					integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
					crossorigin="anonymous"></script>

			</div>
		</div>
	</section>

</body>

</html>