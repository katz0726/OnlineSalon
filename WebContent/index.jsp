<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- Font Awsome -->
		<script src="https://kit.fontawesome.com/c645960b6a.js"></script>

		<!-- Spin.js -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/spin.js/2.3.2/spin.js"></script>
		<!-- 共通CSS -->
		<link rel="stylesheet" type="text/css" href="css/style.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="css/login.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Const.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Login.js"></script>

		<title>HOME</title>
	</head>
	<body>
		<!-- header -->
		<div id="header"><jsp:include page="html\element\header.jsp" flush="true" /></div>

		<div id="contents">
			<div id="contents-inner">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">Eメールアドレス</label>
		    			<input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
		    		</div>

		    		<div class="form-group">
						<label for="password">パスワード</label>
		    			<input type="password" name="password" class="form-control" id="password" placeholder="Password">
					</div>

					<div class="form-group">
						<button type="button" id="login-btn" class="btn btn-primary">ログイン</button>
						<button type="reset" id="clear-btn" class="btn btn-secondary">クリア</button>
					</div>
				</form>
				<a href="${pageContext.request.contextPath}/signup" >サインアップ</a>

			</div>

			<!-- footer -->
			<jsp:include page="html\element\footer.jsp" flush="true" />
		</div>
		<script type="text/javascript">
			// Initialize
			let myCommon = new Common();
			let myLogin = new Login();

			$(function() {
				$('#login-btn').on('click', function(e) {
					let email = $('#email').val();
					let password = $('#password').val();
					let spinTarget = document.getElementById('contents');
					let mySpinner = new Spinner(SPINNER_SETTINGS);

					// In case email is empty
					if (myCommon.inner.checkEmpty(email)) {
						myCommon.inner.setErrorMark('email');
						return false;
					} else if (myCommon.inner.checkEmpty(password)) {
						myCommon.inner.setErrorMark('password');
						return false;
					} else {
						// start spinner
						mySpinner.spin(spinTarget);

						// authentication
						myLogin.inner.auth();

						// stop Spinner
						mySpinner.spin();
					}
				});

				// In case email is focused out
				$('#email').on('focusout', function() {
					myCommon.inner.clearErrorMark('email');
				});

				// In case password is focused out
				$('#password').on('focusout', function() {
					myCommon.inner.clearErrorMark('password');
				});
			});
		</script>
	</body>
</html>