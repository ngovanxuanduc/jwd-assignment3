<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<form action="<%=request.getContextPath()%>/member/edit"
				method="POST"">
				<div class="form-group">
					<label for="exampleFormControlInput1" class="font-weight-bold">First
						Name</label> <input type="text" name="firstName" class="form-control"
						value="${user.firstName }" placeholder="Enter the first name" />
				</div>

				<div class="form-group">
					<label for="exampleFormControlInput1" class="font-weight-bold">Last
						Name</label> <input type="text" name="lastName" class="form-control"
						value="${user.lastName }" placeholder="Enter the last name" />
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1"
						class="font-weight-bold d-block">Email</label> <span>
						${user.email }</span>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1" class="font-weight-bold">Phone</label>
					<input type="text" name="phone" class="form-control"
						value="${user.phone }" placeholder="Enter your phone number" />
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1" class="font-weight-bold">Description</label>
					<textarea class="form-control" name="description" rows="3">${user.description }</textarea>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-outline-secondary">
						Submit Button</button>
					<button type="button" class="btn btn-outline-secondary">
						Reset Button</button>
				</div>
			</form>
		</div>
	</div>