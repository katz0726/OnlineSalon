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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Const.js"></script>

		<!-- 固有JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Signup.js"></script>

		<title>ユーザ登録 | Online Salon</title>
	</head>

	<body>
		<!-- header -->
		<jsp:include page="element\header.jsp" flush="true" />

		<div id="contents">
			<div id="contents-inner">

				<h1>登録</h1>

				<form>
					<div class="form-group">
						<label for="user-name">氏名</label>
	    				<input type="text" name="user_name" class="form-control" id="user-name"  maxlength="100"
	    					placeholder="John Doe">
	    			</div>

	    			<div class="form-group">
						<label for="gender">性別</label>
	    				<select name="gender" id="gender" class="form-control">
							<option id="gender-default" class="gender-option" value=""></option>
							<option id="gender-male" class="gender-option" value="1">男</option>
							<option id="gender-female" class="gender-option" value="2">女</option>
						</select>
	    			</div>

					<div class="form-group">
						<label for="search-id">検索ID</label>
	    				<input type="text" name="search_id" class="form-control" id="search-id" maxlength="15">
	    			</div>

	    			<div class="form-group">
						<label for="email">Email</label>
	    				<input type="email" name="email" class="form-control" id="email" placeholder="xxxxx@sample.com">
					</div>

					<div class="form-group">
						<label for="password">パスワード</label>
	    				<input type="password" name="password" class="form-control" id="password" placeholder="xxxxxxxx" maxlength="12">
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
			let myCommon = new Common();
			let mySignup = new Signup();

			$(function() {
				$('#register-btn').on('click', function(e) {

					// フォームの入力チェック
					mySignup.inner.checkForm();

					// サインアップ処理を実行する
					mySignup.inner.signup(e);
				});
			});
		</script>
	</body>
</html>