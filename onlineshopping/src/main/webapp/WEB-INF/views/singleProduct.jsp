<div class="container mb-5">

	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12 mb-5">

			<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="${contextRoot}/home/">Home</a></li>
				<li class="breadcrumb-item active"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>

		<div class="col-md-6 col-12 ml-5">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" width="400px"
					class="img img-responsive" />

			</div>

		</div>
		<div class="col-md-6 col-12">

			<h3>${product.name}</h3>
			<hr>
			<p>${product.description}</p>
			<hr>
			<h4>
				Price: <strong>Rp ${product.untiPrice}</strong>
			</h4>


			<c:choose>

				<c:when test="${product.quantity <1 }">

					<h6>
						Qty. Available: <span class="text-danger">Out of Stoct!</span>
					</h6>

				</c:when>

				<c:otherwise>

					<h6>
						Qty. Available: <strong> ${product.quantity}</strong>
					</h6>

				</c:otherwise>

			</c:choose>


			<c:choose>

				<c:when test="${product.quantity <1}">

					<a href="javascript:void(0)" class="btn btn-success disabled"> <strike>Add to Cart</strike>  </a>

				</c:when>

				<c:otherwise>

					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success">Add to Cart</a>

				</c:otherwise>

			</c:choose>


			<a href="${contextRoot}/show/all/product" class="btn btn-primary">Back</a>

		</div>


	</div>

</div>