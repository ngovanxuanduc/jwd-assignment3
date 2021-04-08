<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Login</title>
<link
	href="<c:url value="/resources/bootstrap-4.6.0/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/all.min.css" />"
	rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap-4.6.0/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap-4.6.0/js/popper.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap-4.6.0/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap-4.6.0/js/bootstrap.bundle.min.js" />"></script>

<!-- 	https://mkyong.com/spring-mvc/spring-mvc-how-to-include-js-or-css-files-in-a-jsp-page/    -->
<!-- https://itphutran.com/lay-duong-dan-thu-muc-goc-trong-jsp/ -->
</head>
<jsp:include page="header.jsp" />
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-3">

			<jsp:include page="nav.jsp" />
			</div>
			<div class="col-9">

				<c:if test="${edit}">
					<div class="row  p-4 alert alert-success" role="alert">Update
						Success</div>
				</c:if>

				<div class="row p-4">
					<h1>Edit Profile</h1>
				</div>
				<div class="card">
					<div class="card-header">Profile Form Elements</div>
					<div class="card-body w-75">
<%-- 						<form action="<%=request.getContextPath()%>/member/edit" --%>
							<form:form action="edit" method="POST" modelAttribute="editUser">
							<div class="form-group">
								<label for="exampleFormControlInput1" class="font-weight-bold">First
									Name</label> <input type="text" name="firstName" class="form-control"
									value="${user.firstName }" placeholder="Enter the first name" required />
									<form:errors path="firstName" cssClass="text-danger mt-1" />
							</div>

							<div class="form-group">
								<label for="exampleFormControlInput1" class="font-weight-bold">Last
									Name</label> <input type="text" name="lastName" class="form-control"
									value="${user.lastName }" placeholder="Enter the last name" required/>
									<form:errors path="lastName" cssClass="text-danger mt-1" />
							</div>
							<div class="form-group">
								<label for="exampleFormControlInput1"
									class="font-weight-bold d-block">Email</label> <span>
									${user.email }</span>
							</div>
							<div class="form-group">
								<label for="exampleFormControlInput1" class="font-weight-bold">Phone</label>
								<input type="text" name="phone" class="form-control"
									value="${user.phone }" placeholder="Enter your phone number" required/>
									<form:errors path="phone" cssClass="text-danger mt-1" />
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1"
									class="font-weight-bold">Description</label>
								<textarea class="form-control" name="description" rows="3" required>${user.description }</textarea>
								<form:errors path="description" cssClass="text-danger mt-1" />
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-outline-secondary">
									Submit Button</button>
								<a type="button" class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/member/edit">
									Reset Button</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
