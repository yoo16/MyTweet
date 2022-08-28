<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="request" />

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>マイページ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<ul class="navbar-nav ms-auto m-2">
			<li class="nav-item"><a class="nav-link" href="logout">ログアウト</a></li>
		</ul>
	</nav>
	<div class="container">
		<h2 class="text-center">マイページ</h2>
		<p><%=user.name%>さん、ようこそ！
		</p>
	</div>
</body>
</html>