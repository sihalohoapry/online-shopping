<div class="container">

	<div class="row">

		<div class="col-md-12">

			<div class="row">
				<!-- ADD BREADCRUMB -->
				<div class="row mb-3">

					<c:if test="${userClickAllProducts == true }">
					<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home/">Home</a></li>
							<li class="breadcrumb-item active">All Product</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true }">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home/">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>


						</ol>
					</c:if>

				</div>

				<div class="row mb-5">
					<table id="productListTable"
						class="table table-striped table-bordered ">

						<thead>

							<tr>

								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</thead>

						<tfoot>

							<tr>

								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</tfoot>

					</table>
				</div>
			</div>

		</div>

	</div>

</div>
"
