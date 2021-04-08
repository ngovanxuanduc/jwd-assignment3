<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

				<c:if test="${edit}">
					<div class="row  p-4 alert alert-success" role="alert">Update
						Success</div>
				</c:if>
				<div class="row p-4">
					<h1>View Content</h1>
				</div>
				<div class="card">
					<div class="card-header">View Content List</div>
					<div class="card-body">
						<table class="table" id="viewContentTable">
							<thead>
								<th>#</th>
								<th>Title</th>
								<th>Brief</th>
								<th>Create Date</th>
							</thead>
							<tbody>
								<c:forEach items="${contents}" var="item" varStatus="loop">
									<tr>
									<tr>
										<td style="width: 10%">${loop.index +1} </td>
										<td style="width: 20%" ><a class = "text-decoration-none" href="<%=request.getContextPath()%>/content/addcontent?id=${item.id}">${item.title }</a> </td>										<td style="width: 55%">${item.brief }</td>
										<td style="width: 15%"><fmt:formatDate
												value="${item.createDate}" pattern="dd/MM/yyyy" /> <br/>
											<fmt:formatDate value="${item.createDate}"
												pattern="HH:mm" /></td>
									</tr>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
