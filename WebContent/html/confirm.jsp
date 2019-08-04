<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<title>HOME</title>
	</head>
	<body>
		<h1>購入確認</h1>

		<table id="confirm-table">
			<thead>
				<tr>
					<th>ユーザID</th>
					<th>氏名</th>
					<th>Email</th>
					<th>時刻</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${model.id}</td>
					<td>${model.name}</td>
					<td>${model.email}</td>
					<td>${model.timestamp}</td>
				<tr>
			</tbody>
		</table>
	</body>
</html>