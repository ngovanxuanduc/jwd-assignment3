<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Register</title>
<link
	href="<c:url value="/resources/bootstrap-4.6.0/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/all.min.css" />"
	rel="stylesheet">
<!-- 	https://mkyong.com/spring-mvc/spring-mvc-how-to-include-js-or-css-files-in-a-jsp-page/    -->
<!-- https://itphutran.com/lay-duong-dan-thu-muc-goc-trong-jsp/ -->
</head>
<body>
	<div class=" container w-25 mt-5">
		<div class="row">
			<div class="card ">
				<div class="card-body">
					<h4 class="card-title mb-4 mt-1">Register</h4>
					<form action="" method="POST" onsubmit="return valid()">
						<div class="form-group ">
							<input name="userName" class="form-control"
								placeholder="User Name" type="text" size="50" required>
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<input name="email" class="form-control" placeholder="E-mail"
								type="email" size="50" required>
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<input name="password" class="form-control"
								placeholder="Password" type="password" size="50" required
								id="password">
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<input class="form-control" placeholder="Re Password"
								type="password" size="50" required id="confirm_password">
							<span id="message"></span>
						</div>
						<!-- form-group// -->
						<div class="form-group"></div>
						<!-- form-group// -->
						<div class="form-group">
							<button type="submit" class="btn btn-success btn-block">
								Register</button>
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<a class="" href="<%=request.getContextPath()%>/auth/login">Click here to Login</a>
						</div>
						<div class="form-group">
                   <c:if test="${param['errors']}">
                   	<span class="text-danger">UserName Exists !!!</span>
                   </c:if>
                </div> 
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function valid() {
				const edtPass = document.getElementById("password");
				const edtCfPass = document.getElementById("confirm_password");
				const spMessage = document.getElementById("message");
				if (edtCfPass.value !== edtPass.value) {
					spMessage.innerHTML = "Password And Confirm Password Not Matching";
					spMessage.style.color = "red";
					return false;
				}
				return true;
			}
		</script>
</body>
</html>
