<div class="container">

	<div class="row">

		<div class="col-md-12">

			<div class="row">
				<!-- ADD BREADCRUMB -->
				<div class="row">

					<c:if test="${userClickAllProducts == true }">
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home/">Home</a></li>
							<li class="breadcrumb-item active">All Product</li>

						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true }">
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home/">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
							

						</ol>
					</c:if>
					
				</div>

			</div>

		</div>

	</div>

</div>
"
