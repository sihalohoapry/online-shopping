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
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->

<link href="${css}/bootstrap.css" rel="stylesheet" />

<link href="${css}/datatables.css" rel="stylesheet" />
<link href="${css}/myapp.css" rel="stylesheet" />

<script type="text/javascript"
	src="https://ff.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=ZeHfUapcarOFQ6ypv8RfJnuxT_oUgX7sfiPfFtV45U0ANA7O8JOdBMe1rl5P2SMXAcP_ET91xkDxEYmgIWoRy1XgMSckYzhOnZ_yH_BRbw0"
	charset="UTF-8"></script>
</head>
<body>

	<div class="wrapper">
		
		<%@include file="flows-navbar.jsp" %>


		<!-- content -->

		<div class="content mt-3">