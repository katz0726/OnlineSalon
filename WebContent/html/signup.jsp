<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- jQuery UI -->
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- 共通CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>

		<title>ユーザ登録</title>
	</head>

	<body>
		<!-- header -->
		<jsp:include page="element\header.jsp" flush="true" />

		<div id="contents">
			<div id="contents-inner">

				<h1>登録</h1>

				<form action="${pageContext.request.contextPath}/register" method="post">
					<div class="form-group">
						<label for="user-name">氏名</label>
	    				<input type="text" name="username" class="form-control" id="user-name"  placeholder="John Doe">
	    			</div>

	    			<div class="form-group">
						<label for="email">Email</label>
	    				<input type="email" name="email" class="form-control" id="email" placeholder="xxxxx@sample.com">
					</div>

					<div class="form-group">
						<label for="password">パスワード</label>
	    				<input type="password" name="password" class="form-control" id="password" placeholder="xxxxxxxx">
					</div>


					<div class="form-group">
						<button type="submit" class="btn btn-primary" id="register-btn">登録</button>
						<button type="reset" class="btn btn-secondary">クリア</button>
					</div>
				</form>
			</div>

			<!-- footer -->
			<jsp:include page="element\footer.jsp" flush="true" />
		</div>

		<script type="text/javascript">
			var myCommon = new Common();
			$('#email').on('blur', function() {
					setErrorMark('email');
			});
		</script>
	</body>
</html>