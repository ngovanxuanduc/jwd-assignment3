<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
                    <td style="width: 10%">${loop.index}</td>
                    <td style="width: 20%">${item.title }</td>
                    <td style="width: 55%">${item.brief }</td>
                    <td style="width: 15%"><fmt:formatDate value="${item.createDate}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                  </tr>
    					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

