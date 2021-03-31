<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <title>Login</title>
    <link href="<c:url value="/resources/bootstrap-4.6.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/fontawesome/css/all.min.css" />" rel="stylesheet">
<!-- 	https://mkyong.com/spring-mvc/spring-mvc-how-to-include-js-or-css-files-in-a-jsp-page/    -->
<!-- https://itphutran.com/lay-duong-dan-thu-muc-goc-trong-jsp/ -->
</head>
  <body>
    <div class=" container w-25 mt-5">
        <div class="card">
        <div class="card-body">
          
            <h4 class="card-title mb-4 mt-1">Please Sign In</h4>
                 <form action="<%=request.getContextPath()%>/auth/login" method="POST">
                <div class="form-group">
                    <input name="userName" class="form-control" placeholder="E-mail" type="text" required>
                </div> <!-- form-group// -->
                <div class="form-group">
                    <input name="password" class="form-control" placeholder="password" type="password" required>
                </div> <!-- form-group// --> 
                <div class="form-group"> 
                <div class="checkbox">
                  <label> <input type="checkbox"> Remember me </label>
                </div> <!-- checkbox .// -->
                </div> <!-- form-group// -->  
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"> Login  </button>
                </div> <!-- form-group// -->   
                <div class="form-group">
                    <a class="" href="<%=request.getContextPath()%>/auth/register">Click here to Register</a>
                </div>            
                 <div class="form-group">
                   <c:if test="${param['errors']}">
                   	<span class="text-danger">Incorrect UserName / Password</span>
                   </c:if>
                </div>                                         
                
            </form>
        </div>
    </div>
  </body>
</html>
