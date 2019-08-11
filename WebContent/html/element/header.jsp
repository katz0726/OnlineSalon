<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- Fontawsome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.10.1/css/all.css" integrity="sha384-wxqG4glGB3nlqX0bi23nmgwCSjWIW13BdLUEYC4VIMehfbcro/ATkyDsF/AbIOVe" crossorigin="anonymous">

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
	</head>
	<body>
		<div id="header-area">
			<!-- HOME -->
			<div id="home-area" class="header-item">
				<i class="fas fa-home"></i>
				<a href="${pageContext.request.contextPath}/menu/home" class="header-item-link"><span class="headrer-item-title">HOME</span></a>
			</div>

			<!-- TALK -->
			<div id="talk-area" class="header-item">
				<i class="fas fa-comment-dots"></i>
				<a href="${pageContext.request.contextPath}/menu/talk" class="header-item-link"><span class="headrer-item-title">TALK</span></a>
			</div>

			<!-- ADD FRIENDS -->
			<div id="add-friends-area" class="header-item">
				<i class="fas fa-user-plus"></i>
				<a href="${pageContext.request.contextPath}/menu/add" class="header-item-link"><span class="headrer-item-title">ADD FRIENDS</span></a>
			</div>

			<!-- TIMELINE -->
			<div id="timeline-area" class="header-item">
				<i class="fas fa-clock"></i>
				<a href="${pageContext.request.contextPath}/menu/timeline" class="header-item-link"><span class="headrer-item-title">TIMELINE</span></a>
			</div>
		</div>
	</body>
</html>