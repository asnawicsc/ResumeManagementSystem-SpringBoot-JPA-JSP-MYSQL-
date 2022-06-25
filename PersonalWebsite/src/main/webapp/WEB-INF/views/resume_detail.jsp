<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href='https://fonts.googleapis.com/css?family=Josefin+Sans&subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdn.rawgit.com/konpa/devicon/master/devicon.min.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
img {
	border-radius: 50%;
	width:200px;
}

.container {
	position: relative;
}

.topright {
	position: absolute;
	top: 18px;
	right: 240px;
	font-size: 18px;
}

body {
	background: #1B1B25;
	color: #fff;
	font-family: 'Josefin Sans', sans-serif;
}

.separator {
	width: 30%;
}

.title {
	margin-top: 100px;
	margin-bottom: 10px; a { color : #DB4D57; &: hover { text-decoration :
	none;
	font-weight: bold;
}

}
hr {
	width: 75%;
}

}
.summary {
	padding: 20px; p { font-size : 1.6rem;
	letter-spacing: .2rem;
}

}
.work-experience {
	padding: 20px;
	.
	experience-title
	{
	margin-top
	:
	50px;
}

.experience-summary {
	margin-top: 30px;
	margin-bottom: 50px;
}

p {
	font-size: 1.6rem;
	letter-spacing: .2rem;
}
}
</style>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Resume Detail</title>

</head>

<body>

	<header id="print_hide">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/">Home</a></li>
				</div>
			</div>

		</nav>

	</header>

	<div class="container">
		<div class="topright">
			<button type="button" id="print_hide" class="btn btn-outline-success">
				<a hreff="#" onClick="javascript:window.print();">Print</a>
			</button>
			<a href="/delete_resume/${model.get('user').id}"><button
					type="button" id="print_hide" class="btn btn-outline-danger">Delete
					Resume</button></a>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="title text-center">

					<h3>
						<img alt="Avatar"
							src="/../user-photos/${model.get('user').id}/${model.get('user').img_src}" />
					</h3>
					<h1>${model.get('user').first_name}${model.get('user').last_name}</h1>
					<h6>${model.get('user').address}</h6>
					<h4>
						<a href="mailto:${model.get('user').email}">${model.get('user').email}</a>
					</h4>
					<hr />

				</div>
				<!-- personal particular section -->
				<div class="summary">
					<h2 class="text-center">Personal Particular</h2>
					<p>
						<a href="/update_personal_particular/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Personal Info</button></a>
					</p>

					<div class="row">
						<div class="col-md-12 col-sm-12">
							<p>SAP ID -> ${model.get('user').personal_id}</p>
							<p>Age -> ${model.get('user').age}YearOld</p>
							<p>Phone Number -> ${model.get('user').phone_number}</p>
						</div>

					</div>

				</div>


				<!-- objective section section -->
				<div class="summary">
					<h2 class="text-center">Objective Career</h2>
					<p>
						<a href="/update_user_objective/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Objective</button></a>
					</p>

					<div class="row">
						<div class="col-md-12 col-sm-12">
							<c:forEach var="list" items="${model.get('list_user_objective')}">
								<p>${list.objective_desc}</p>

							</c:forEach>

						</div>

					</div>


				</div>
				<!-- education section section -->

				<!-- work experience section -->
				<div class="work-experience">
					<h2 class="text-center">Education</h2>
					<p>
						<a href="/update_user_education/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Education</button></a>
					</p>
					<br>
					<c:forEach var="list" items="${model.get('list_user_education')}">


						<div class="row experience-title">
							<div class="col-md-9">
								<h3>${list.education_title}</h3>
								<h4></h4>
								<h5>Grade: ${list.grade}</h5>
							</div>
							<div class="col-md-3">
								<h6>${list.year_start}-${list.year_end}</h6>
							</div>
						</div>
						<br>
						<div class="row experience-summary">
							<div class="col-md-12">
								<p>${list.education_desc}</p>
							</div>
						</div>
						<br>
					</c:forEach>

				</div>
				<!-- objective section section -->
				<div class="summary">
					<h2 class="text-center">Experience</h2>
					<p>
						<a href="/update_user_experience/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Experience</button></a>
					</p>
					<br>
					<c:forEach var="list" items="${model.get('list_user_experience')}">


						<div class="row experience-title">
							<div class="col-md-9">
								<h3>${list.experience_title}</h3>
								<h4></h4>
								<h5>Company: ${list.company_name}</h5>
							</div>
							<div class="col-md-3">
								<h6>${list.year_start}-${list.year_end}</h6>
							</div>
						</div>
						<br>
						<div class="row experience-summary">
							<div class="col-md-12">
								<p>${list.experience_desc}</p>
							</div>
						</div>
						<br>
					</c:forEach>



				</div>
				<!-- objective section section -->
				<div class="summary">
					<h2 class="text-center">Awards</h2>
					<p>
						<a href="/update_user_awards/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Awards</button></a>
					</p>
					<br>
					<c:forEach var="list" items="${model.get('list_user_awards')}">


						<div class="row experience-title">
							<div class="col-md-8">
								<h3>${list.awards_desc}</h3>

							</div>
							<div class="col-md-4">
								<h3>${list.year_start}-${list.year_end}</h3>
							</div>
						</div>
						<br>

					</c:forEach>


				</div>



				<!-- work experience section -->
				<div class="work-experience">
					<h2 class="text-center">Acknowledgments</h2>
					<p>
						<a href="/update_user_acknowledgments/${model.get('user').id}"><button
								type="button" id="print_hide" class="btn btn-outline-info">Update
								Acknowledgments</button></a>
					</p>
					<br>
					<c:forEach var="list"
						items="${model.get('list_user_acknowledgments')}">


						<div class="row experience-title">
							<div class="col-md-8">
								<h3>${list.acknowledgments_desc}</h3>

							</div>
							<div class="col-md-4">
								<h3>${list.year}</h3>
							</div>
						</div>
						<br>

					</c:forEach>

				</div>
			</div>
		</div>
	</div>



</body>

</html>
<style>
@media print {
	#print_hide {
		display: none;
	}
}
</style>
