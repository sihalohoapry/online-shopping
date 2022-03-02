<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container ">
	<!-- Ini content -->
	
	<c:if test="${not empty message}">

		<div class="alert alert-success alert-dismissible">

			<button type="button" class="close" style="float: right;"
				data-dismiss="alert">&times;</button>
			${message}

		</div>

	</c:if>

	<h3>Add Product</h3>

	<div class="card mb-5">
		<div class="card-body">
			<sf:form modelAttribute="product"
				action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data" > 
				<div class="row">
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label>Nama</label>
							<sf:input type="text" path="name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label>Brand</label>
							<sf:input type="text" path="brand" class="form-control" />
							<sf:errors path="brand" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label>Description</label>
							<div>
								<sf:textarea class="col-md-12" path="description"
									id="description" rows="4" placeholder="Write a description"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
					</div>

					<div class="col-md-6 mt-3">
						<div class="form-group">
							<label>Unit per price</label>
							<sf:input type="number" path="untiPrice" class="form-control" />
							<sf:errors path="untiPrice" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="col-md-6 mt-3">
						<div class="form-group">
							<label>Quantity</label>
							<sf:input type="number" path="quantity" class="form-control" />
							<sf:errors path="quantity" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label>Category</label>
							<sf:select name="role" class="form-control" id="categoryId"
								path="categoryId" items="${categories }" itemLabel="name"
								itemValue="id" />
								<c:if test="${product.id == 0}">
									<div style="float: right">
									<br>
									<button type="button" class="btn btn-warning btn-xs" data-bs-toggle="modal" data-bs-target="#myCategoryModal">
  									Add Category
									</button>
								</div>
								</c:if>
						</div>
					</div>
					
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label for="file">Image</label>
							<sf:input type="file"  path="file" class="form-control" />
							<sf:errors path="file" cssClass="help-block" element="em" />
						</div>
					</div>

				</div>
				<div class="row mt-4">
					<div class="col text-right">
						<button type="submit" class="btn btn-success px-5">Submit</button>
					</div>
				</div>

				<sf:hidden path="id" />
				<sf:hidden path="code" />
				<sf:hidden path="supplierId" />
				<sf:hidden path="purchases" />
				<sf:hidden path="view" />
			</sf:form>
		</div>
	</div>
	
	<div class="row">
	
		<div class="col-xs-12">
			<h3>Available Products</h3>
		</div>
	
		<div class="col-xs-12 mb-5">
		
			<div style="overflow:auto">
			
				<table id="adminProductsTable" class="table table-striped table-bordered">
								
					<thead>
					
						<tr>
						
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
							
						
						</tr>
					
					</thead>
					
					
					
					<tfoot>
					<tr>
						
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
							
						
						</tr>
					</tfoot>
				
				
				</table>
				
			
			</div>
		
		</div>
	
	
	</div>


<!-- Modal -->
<div class="modal fade" id="myCategoryModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myModalLabel">New Category</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="modal-body">
	        
	        <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-12 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4 mt-3">Description</label>
					<div class="col-md-12 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	        	        
	        
	        
				<div class="form-group mt-3">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>	        
	        </sf:form>
	      </div>
      </div>
    </div>
  </div>
</div>



	

</div>
