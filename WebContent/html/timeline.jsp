<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- 共通CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>

		<title>タイムライン</title>
	</head>
	<body>
		<!-- header -->
		<jsp:include page="element\header.jsp" flush="true" />

		<div id="contents">
			<div id="contents-inner">
				<h1>タイムライン</h1>
			</div>

			<!-- footer -->
			<jsp:include page="element\footer.jsp" flush="true" />
		</div>
	</body>
</html>