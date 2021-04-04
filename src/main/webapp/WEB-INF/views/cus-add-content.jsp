<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row p-4">
	<h1>Add Content</h1>
</div>
<div class="card">
	<div class="card-header">Content Form Elements</div>
	<div class="card-body w-75">
		<form>
			<div class="form-group">
				<label for="exampleFormControlInput1" class="font-weight-bold">Title</label>
				<input type="text" name="title" class="form-control"
					placeholder="Enter the title" />
			</div>

			<div class="form-group">
				<label for="exampleFormControlTextarea1" class="font-weight-bold">Brief</label>
				<textarea class="form-control" name="brief" rows="3"></textarea>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1" class="font-weight-bold">Content</label>
				<textarea class="form-control" name="content" rows="7"></textarea>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-outline-secondary">
					Submit Button</button>
				<button type="button" class="btn btn-outline-secondary">
					Reset Button</button>
			</div>
		</form>
	</div>
</div>

