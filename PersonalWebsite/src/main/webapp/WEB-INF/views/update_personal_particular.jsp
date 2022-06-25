<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Personal Info</title>
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
			<div class="card-header">Update for: ${user.first_name}
				${user.last_name}</div>
			<div class="card-body">

				<form:form method="POST" enctype="multipart/form-data"
					modelAttribute="user" commandName="user" class="form-horizontal"
					action="/updateUser">
					<div class='loginForm'>

						<br>
						<div class="row">
							<div class="form-group col-md-12">

								<div class="col-md-7">
									<form:hidden path="id" class="form-control input-sm" />
									<div class="has-error"></div>
								</div>
							</div>
						</div>
						<div class="form-floating mb-3">
							<form:input type="number" path="personal_id" id="personal_id"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="personal_id" class="help-inline" />
							</div>
							<label for="personal_id">Personal ID</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="text" path="first_name" id="first_name"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="first_name" class="help-inline" />
							</div>
							<label for="first_name">First Name</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="text" path="last_name" id="last_name"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="last_name" class="help-inline" />
							</div>
							<label for="first_name">Last Name</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="text" path="address" id="address"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="address" class="help-inline" />
							</div>
							<label for="first_name">Address</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="number" path="age" id="age"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="age" class="help-inline" />
							</div>
							<label for="age">Age</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="number" path="phone_number" id="phone_number"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="age" class="help-inline" />
							</div>
							<label for="phone_number">Phone Number</label>
						</div>
						<div class="form-floating mb-3">
							<form:input type="text" path="email" id="email"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
							<label for="email">Email</label>
						</div>

						<h3>
							<img alt="Avatar"
								src="/../user-photos/${user.id}/${user.img_src}"
								style="width: 100px;" />
						</h3>

						<div class="form-floating mb-3">
							<form:input type="file" path="img_src" id="img_src"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="img_src"
									accept="image/png, image/gif, image/jpeg" class="help-inline" />
							</div>
							<label for="img_src">Image</label>
						</div>


						<br>
						<button type="submit" class="btn btn-outline-success">Submit</button>
						<a href="/resume_detail/${user.id}"><button type="button"
								class="btn btn-outline-danger">Back To My Resume</button></a>
					</div>
				</form:form>


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