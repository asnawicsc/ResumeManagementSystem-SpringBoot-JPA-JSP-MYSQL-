
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Objective</title>
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

				<form action="/editObjectivesubmit" method="post">
					<div class='loginForm'>
						<h1>Edit User Objective</h1>
						<br>

						<div class="form-floating mb-3">
							<input type="hidden" value="${userobjective.id}"
								class="form-control" id="id" name="id">
						</div>
						<div class="form-floating mb-3">
							<input type="hidden" value="${userobjective.user_id}"
								class="form-control" id="user_id" name="user_id">
						</div>

						<div class="form-floating mb-3">
							<input type="text" class="form-control"
								value="${userobjective.objective_desc}" id="objective_desc"
								name="objective_desc"> <label for="objective_desc">Objective</label>
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