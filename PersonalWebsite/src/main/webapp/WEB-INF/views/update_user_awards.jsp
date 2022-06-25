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
<title>My Awards</title>

</head>
<body>
	<section>

		<div class="card" style="margin: 10px;]">
			<div class="card-body">
				<h1 align="center">${model.get('user').first_name}
					List Awards <a href="/resume_detail/${model.get('user').id}"><button
							type="button" class="btn btn-outline-success">Back To My
							Resume</button></a>
				</h1>
				<table id="t02" cellpadding="2">
					<tr>
						<th><a href="/create_new_user_awards/${model.get('user').id}"><button
									type="button" class="btn btn-outline-info">Add New
									Awards</button></a></th>

						<th></a></th>
					</tr>
				</table>
				<br>

				<form:form class="form-horizontal">
					<table class="table">
						<tr>
							<th>Id</th>
							<th>User ID</th>
							<th>Year Start</th>
							<th>Year End</th>
							<th>Awards Description</th>

							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<c:forEach var="userawards"
							items="${model.get('all_user_awards')}">
							<tr>
								<td>${userawards.id}</td>
								<td>${userawards.user_id}</td>
								<td>${userawards.year_start}</td>
								<td>${userawards.year_end}</td>
								<td>${userawards.awards_desc}</td>
								<td><a
									href="/edituserawards/${model.get('user').id}/${userawards.id}">Edit</a></td>
								<td><a
									href="/deleteuserawards/${model.get('user').id}/${userawards.id}">Delete</a></td>
							</tr>
						</c:forEach>



					</table>
					<br />


				</form:form>
			</div>
		</div>
	</section>
	<section>