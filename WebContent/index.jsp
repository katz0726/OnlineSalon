<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>HOME</title>
	</head>
	<body>
		<div id="header"><jsp:include page="html\element\header.jsp" flush="true" /></div>

		<div id="contents">
			<h1>トップ画面</h1>

			<form action="api/confirm" method="post">
				<p>ID: <input type="text" name="id" id="user-id" /></p>
				<p>氏名： <input type="text" name="name" id="name" /></p>
				<p>Email： <input type="text" name="email" id="email" /></p>

				<button type="submit" id="submit">送信</button>
				<button type="reset" id="clear">クリア</button>
			</form>

			<a href="api/hello-mvc" >コチラをクリック</a>
		</div>


		<div id="footer"><jsp:include page="html\element\footer.jsp" flush="true" /></div>
	</body>
</html>