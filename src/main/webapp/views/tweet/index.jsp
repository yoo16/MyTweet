<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<main class="w-50 m-auto mt-5">
		<h2 class="text-center">ログイン</h2>
		<form action="auth" method="post">
			<div class="form-floating">
				<input type="text" name="email" value="<%= request.getAttribute("email") %>"
					class="form-control border-0 border-bottom rounded-0"
					id="floatingInput" placeholder="test@example.com">
					<label for="floatingInput">Email</label>
			</div>

			<div class="form-floating">
				<input type="password" name="password"
					class="form-control border-0 border-bottom rounded-0"
					id="floatingPassword" placeholder="パスワード"> <label
					for="floatingPassword">パスワード</label>
			</div>
			<p class="text-danger p-2"><%= request.getAttribute("errors") %></p>
			<div class="d-grid mt-2">
				<button class="btn btn-primary">ログイン</button>
			</div>
		</form>
	</main>
</body>

</html>