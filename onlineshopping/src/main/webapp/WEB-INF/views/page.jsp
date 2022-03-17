<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shopping Online - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<!-- Favicon
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
-->
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
	
	
<!-- Core theme CSS (includes Bootstrap)-->

<link href="${css}/bootstrap.css" rel="stylesheet" />
<link href="${css}/datatables.css" rel="stylesheet" />
<link href="${css}/myapp.css" rel="stylesheet" />


</head>
<body>

	<div class="wrapper">

		<!-- Navigation-->
		<%@include file="./shered/navbar.jsp"%>

		<!-- content -->

		<div class="content mt-5">
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="listProduct.jsp"%>
			</c:if>
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowCart == true }">
				<%@include file="cart.jsp"%>
			</c:if>

		</div>


		<!-- Footer-->
		<%@include file="./shered/footer.jsp"%>

		<!-- Bootstrap core JS-->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/datatables.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/myapp.js"></script>

		

		<!-- Core theme JS-->


	</div>
</body>
</html>