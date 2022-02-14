<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container ">
	<!-- Ini content -->

	<c:if test="${not empty message}">

		<!-- 		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<strong>Holy guacamole!</strong> You should check in on some of those
			fields below.
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div> -->

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
						</div>
					</div>
					
					<div class="col-md-12 mt-3">
						<div class="form-group">
							<label for="file">Image</label>
							<sf:input type="file"  path="file" class="form-control" />
							<sf:errors path="file" />
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

</div>
