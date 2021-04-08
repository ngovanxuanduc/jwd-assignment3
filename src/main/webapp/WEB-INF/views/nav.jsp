<form class="form-inline" method="GET" action="viewcontent">
	<div class="input-group">
		<input type="text" class="form-control" placeholder="Search..."
			aria-describedby="basic-addon1" size="50" name = "content" />
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1"> <i
				class="fas fa-search"></i></span>
		</div>
	</div>
</form>
<div class="row mt-3">
	<div class="col-12">
		<a class="h5 my-4 d-block text-decoration-none"
			href="<%=request.getContextPath()%>/content/viewcontent"> <i
			class="fas fa-th mr-2"></i>View contents
		</a> <a class="h5 d-block text-decoration-none"
			href="<%=request.getContextPath()%>/content/addcontent"><i
			class="fas fa-edit mr-1"></i> Form content</a>
	</div>
</div>