<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="request" />

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tweet</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/default.css">
</head>

<body>
	<div class="container-fluid">

		<div class="row">
			<header class="col-md-3">
				<nav id="side-menu">
					<ul>
						<li class="d-flex p-2"><a href=""><span class="icon icon-home"></span><span class="">ホーム</span></a></li>
						<li class="d-flex p-2"><a href="user/logout"><span class="icon"></span><span class="">ログアウト</span></a></li>
					</ul>
				</nav>
			</header>

			<main class="col-md-6">
				<h2 class="h2 mt-3">ツイート</h2>
				<div class="row">
					<form action="tweet/add" method="post">
						<p><%= user.name %>さん</p>
						<textarea name="message" class="form-control" placeholder="いまどうしてる？"></textarea>
						<div class="mt-3 mb-3 text-center">
							<button class="btn btn-primary rounded-pill w-25">つぶやく</button>
						</div>
						<input type="hidden" name="user_id" value="<%= user.id %>">
					</form>
				</div>

				<div class="row">
					<div class="tweet d-flex">
						<div class="tweet-img">
							<img src="./images/me.png">
						</div>

						<div class="tweet-body">
							<div class="tweet-user">
								<span class="fw-bold">@Tokyo Taro</span>
								<span class="ms-1 text-secondary">30分前</span>
							</div>
							<div class="tweet-text mt-2 mb-2">東京駅にいます！</div>
						</div>
					</div>
				</div>
			</main>

			<aside id="sub-contents" class="col-md-3 mt-3">
			</aside>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>