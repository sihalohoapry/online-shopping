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
					aria-current="page" href="${contextRoot}/home">Home</a>
					</li>
				<li class="nav-item"><a class="nav-link" id="about"
					aria-current="page" href="${contextRoot}/about">About</a>
					</li>
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
			
				<li class="nav-item"><a class="nav-link" id="manageProducts"
					aria-current="page" href="${contextRoot}/manage/products">Manage Products</a>
					</li>
			
			</ul>
			<form class="d-flex">
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</button>
			</form>
		</div>
	</div>
</nav>
