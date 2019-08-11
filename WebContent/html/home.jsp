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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>

		<title>ホーム</title>
	</head>
	<body>
		<!-- header -->
		<div id="header"><jsp:include page="element\header.jsp" flush="true" /></div>

		<div id="contents">
			<div id="contents-inner">

				<div id="group-area">
					<p class="subtitle" id="subtitle-groups">グループ</p>
					<table class="table" id="group-table">
						<tbody>
							<c:forEach var="group" items="${it}">
								<tr>
									<td class="group-icon-item"><img src="${pageContext.request.contextPath}/img/hinano.jpg" class="group-icon" /></td>
									<td class="group-name-item"><c:out value="${ group.group_name }" /></td>
									<td class="modified-item"><c:out value="${ group.modified }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<p class="subtitle" id="subtitle-friends">友だち</p>
					<table class="table" id="friend-table">
						<tbody>
							<c:forEach var="friend" items="${it}">
								<tr>
									<td class="friend-icon-item"><img src="${pageContext.request.contextPath}/img/neru.png" class="group-icon" /></td>
									<td class="friend-name-item"><c:out value="${ friend.group_name }" /></td>
									<td class="modified-item"><c:out value="${ friend.modified }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- footer -->
		<div id="footer"><jsp:include page="element\footer.jsp" flush="true" /></div>

		<script type="text/javascript">
			var common = new Common();

			// グループをクリックした場合
			$(function() {
				$('#subtitle-groups').on('click', function() {
					$('#group-table').children().slideToggle();
					$(this).toggleClass('open');
				});

				// 友だちをクリックした場合
				$('#subtitle-friends').on('click', function() {
					$('#friend-table').children().slideToggle();
					$(this).toggleClass('open');
				});
			});
		</script>
	</body>
</html>