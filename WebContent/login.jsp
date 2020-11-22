<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Health Track</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./css/style_brum.css" />
<link rel="stylesheet" href="./assets/fonts/style.css" />
</head>
<body>
	<div class="login-container col-md-6 mb-3">
		<img class="mb-5" src="../assets/images/logo.svg"
			alt="Logo Health Track">
		<form method="post" action="login"
			class="needs-validation form-signin" novalidate>
			<div class="mb-2">
				<label for="input-login">Login</label> <input type="text"
					class="form-control" name="user" id="input-login" required>
				<div class="invalid-feedback">Login required</div>
			</div>
			<div>
				<label for="input-password">Password</label> <input type="password"
					class="form-control" name="password" id="input-password" required>
				<div class="invalid-feedback">Password required</div>
			</div>
			<div class="mt-1 mb-2">
				<div class="form-check d-flex justify-content-end">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
			</div>
			<button class="btn btn-lg btn-block" type="submit">Sign in</button>
		</form>
		<p class="mb-1 mt-1 text-center">or</p>
		<a href="../signup/index.html" class="btn btn-lg btn-block">Sign
			up</a>
	</div>
	<script type="text/javascript" src="../../js/validateForm.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>