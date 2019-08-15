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
		<!-- 共通CSS -->
		<link rel="stylesheet" type="text/css" href="css/style.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="css/login.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>

		<title>HOME</title>
	</head>
	<body>
		<!-- header -->
		<div id="header"><jsp:include page="html\element\header.jsp" flush="true" /></div>

		<div id="contents">
			<div id="contents-inner">

				<form action="${pageContext.request.contextPath}/home" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Eメールアドレス</label>
	    				<input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
	    			</div>

	    			<div class="form-group">
						<label for="password">パスワード</label>
	    				<input type="password" name="password" class="form-control" id="password" placeholder="Password">
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary">ログイン</button>
						<button type="reset" class="btn btn-secondary">クリア</button>
					</div>
				</form>

				<a href="${pageContext.request.contextPath}/signup" >サインアップ</a>
			</div>
		</div>

		<!-- footer -->
		<div id="footer"><jsp:include page="html\element\footer.jsp" flush="true" /></div>
	</body>
</html>