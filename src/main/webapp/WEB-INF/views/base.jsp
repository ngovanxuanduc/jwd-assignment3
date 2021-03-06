<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<header>
	<div class="container-fluid border-bottom mb-3">
		<div class="row d-flex justify-content-between">
			<h3 class="p-3">CMS</h3>
			<div class="dropdown p-3">
				<button class="btn btn-light dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<i class="fas fa-user"></i>
					
				</button>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>User
						Profile</a> <a class="dropdown-item" href="#"><i
						class="fas fa-sign-out-alt mr-2"></i>Logout</a>
				</div>
			</div>
		</div>
		<div class="row"></div>
	</div>
</header>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-3">
				<form class="form-inline">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search..."
							aria-describedby="basic-addon1" size="50" />
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1"> <i
								class="fas fa-search"></i></span>
						</div>
					</div>
				</form>
				<div class="row mt-3">
					<div class="col-12">
						<a class="h5 my-4 d-block text-decoration-none" href="<%=request.getContextPath()%>/content/"> <i
							class="fas fa-th mr-2"></i>View contents
						</a> <a class="h5 d-block text-decoration-none" href="#"><i
							class="fas fa-edit mr-1"></i> Form content</a>
					</div>
				</div>
			</div>
			<div class="col-9" id="contentAjax">
				<h1>${url }</h1>
			</div>
		</div>
	</div>
	<script>
      const divContent = document.getElementById("contentAjax");
    
      $(document).ready(function () {
        console.log("ready!");
        fetch('${url }')
          .then((response) => response.body)
          .then((rb) => {
            const reader = rb.getReader();
            return new ReadableStream({
              start(controller) {
                // The following function handles each data chunk
                function push() {
                  // "done" is a Boolean and value a "Uint8Array"
                  reader.read().then(({ done, value }) => {
                    // If there is no more data to read
                    if (done) {
                      console.log("done", done);
                      controller.close();
                      return;
                    }
                    // Get the data and send it to the browser via the controller
                    controller.enqueue(value);
                    // Check chunks by logging to the console
                    console.log(done, value);
                    push();
                  });
                }

                push();
              },
            });
          })
          .then((stream) => {
            // Respond with our stream
            return new Response(stream, {
              headers: { "Content-Type": "text/html" },
            }).text();
          })
          .then((result) => {
            // Do things with result
            console.log(result);
//             window.history.pushState("page1", "Title", '${url }');
            renderRow(result);
          });
      
      });

      function renderRow(data) {
        divContent.innerHTML = data;
      }
    </script>
</body>
</html>
