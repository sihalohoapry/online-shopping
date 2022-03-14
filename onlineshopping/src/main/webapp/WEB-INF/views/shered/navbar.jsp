<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="${contextRoot}/home">OLShop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link " id="home"
					aria-current="page" href="${contextRoot}/home">Home</a></li>
				<li class="nav-item"><a class="nav-link" id="about"
					aria-current="page" href="${contextRoot}/about">About</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="${contextRoot}/show/all/products">All Products</a></li>

						<c:forEach items="${categories}" var="category">
							<li><a class="dropdown-item"
								href="${contextRoot}/show/category/${category.id}/products">${category.name}</a></li>
						</c:forEach>



					</ul></li>

				<security:authorize access="hasAuthority('ADMIN')">

					<li class="nav-item"><a class="nav-link" id="manageProducts"
						aria-current="page" href="${contextRoot}/manage/products">Manage
							Products</a></li>

				</security:authorize>

			</ul>

			<ul class="navbar-nav navbar-right mb-2 mb-lg-0 ms-lg-4"
				style="margin-right: 20px;">

				<security:authorize access="isAnonymous()">
					<li class="nav-item " style="margin-right: 10px;"><a
						class="btn btn-outline-dark " id="manageProducts"
						aria-current="page" href="${contextRoot}/register">Sign Up </a></li>
					<li class="nav-item "><a class="btn btn-outline-dark "
						id="manageProducts" aria-current="page"
						href="${contextRoot}/login">Login </a></li>
				</security:authorize>


			</ul>

			<div class="d-flex">
			
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				
				<security:authorize access="isAuthenticated()">

					<li class="nav-item dropdown" style="list-style-type: none; text-decoration:none;">
					<a class="nav-link dropdown-toggle" style="text-decoration:none;" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">${userModel.fullname}</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">

							<security:authorize access="hasAuthority('USER')">
								<li><a class="dropdown-item" href="${contextRoot}/cart"><i
										class="bi-cart-fill me-1"></i> ${userModel.cart.cartLines }</a></li>
								<li class="divider" role="separator"></li>

							</security:authorize>

							<li><a class="dropdown-item" href="${contextRoot}/perform-logout">Logout</a>
							</li>
						</ul></li>

				</security:authorize>
				
				</ul>

				


			</div>



		</div>
	</div>
</nav>

<script>

	window.userRole = '${userModel.role}';
	

</script>

