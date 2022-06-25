<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Objective</title>

</head>
<body>
	<section>

		<div class="card" style="margin: 10px;]">
			<div class="card-body">
				<h1 align="center">${model.get('user').first_name}
					List Objective <a href="/resume_detail/${model.get('user').id}"><button
							type="button" class="btn btn-outline-success">Back To My
							Resume</button></a>
				</h1>
				<table id="t02" cellpadding="2">
					<tr>
						<th><a
							href="/create_new_user_objective/${model.get('user').id}"><button
									type="button" class="btn btn-outline-info">Add New
									Objective</button></a></th>

						<th></a></th>
					</tr>
				</table>
				<br>

				<form:form class="form-horizontal">
					<table class="table">
						<tr>
							<th>Id</th>
							<th>User ID</th>
							<th>Objective</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>

						<c:forEach var="userobjective"
							items="${model.get('all_user_objective')}">
							<tr>
								<td>${userobjective.id}</td>
								<td>${userobjective.user_id}</td>
								<td>${userobjective.objective_desc}</td>
								<td><a
									href="/edituserobjective/${model.get('user').id}/${userobjective.id}">Edit</a></td>
								<td><a
									href="/deleteuserobjective/${model.get('user').id}/${userobjective.id}">Delete</a></td>
							</tr>
						</c:forEach>


					</table>
					<br />


				</form:form>
			</div>
		</div>
	</section>
	<section>