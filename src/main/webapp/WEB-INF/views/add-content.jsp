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
<script
	src="<c:url value="/resources/bootstrap-4.6.0/js/jquery.min.js" />"></script>
<script
	src="<c:url value="/resources/bootstrap-4.6.0/js/popper.min.js" />"></script>
<script
	src="<c:url value="/resources/bootstrap-4.6.0/js/bootstrap.min.js" />"></script>
<script
	src="<c:url value="/resources/bootstrap-4.6.0/js/bootstrap.bundle.min.js" />"></script>

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


				<div class="row p-4">
					<c:choose>
						<c:when test="${!empty oldContent}">
							<h1>Update Content</h1>
						</c:when>
						<c:otherwise>
							<h1>Add Content</h1>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="card">
					<div class="card-header">Content Form Elements</div>
					<div class="card-body w-75">
						<form:form action="addcontent" method="POST" modelAttribute="content">
							<input type="hidden" name="id" class="form-control"value="${oldContent.id}"/>
							<div class="form-group">
								<label for="exampleFormControlInput1" class="font-weight-bold">Title</label>
								<input type="text" name="title" class="form-control"
									placeholder="Enter the title" value="${oldContent.title}"
									required />
									<form:errors path="title" cssClass="text-danger mt-1" />
							</div>

							<div class="form-group">
								<label for="exampleFormControlTextarea1"
									class="font-weight-bold">Brief</label>
								<textarea class="form-control" name="brief" rows="3" required>${oldContent.brief}</textarea>
								<form:errors path="brief" cssClass="text-danger mt-1" />
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1"
									class="font-weight-bold">Content</label>
								<textarea class="form-control" name="content" rows="7" required>${oldContent.content}</textarea>
								<form:errors path="content" cssClass="text-danger mt-1" />
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-outline-secondary">
									Submit Button</button>
								<a type="button" class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/content/addcontent">
									Reset Button</a>
								<c:if test="${!empty  oldContent}">
<%-- 									<a type="button" class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/content/deletecontent"> --%>
<!-- 										Delete Button</a> -->
									<button type="submit" class="btn btn-outline-secondary" formaction="deletecontent">
										Delete Button</button>
								</c:if>
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
