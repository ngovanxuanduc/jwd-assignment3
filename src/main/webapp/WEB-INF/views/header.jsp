
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
					<a class="dropdown-item" href="<%=request.getContextPath()%>/member/edit"><i class="fas fa-user mr-2"></i>User
						Profile</a> 
					<a class="dropdown-item"
						href="<%=request.getContextPath()%>/auth/logout"><i
						class="fas fa-sign-out-alt mr-2"></i>Logout</a>
				</div>
			</div>
		</div>
		<div class="row"></div>
	</div>
</header>
