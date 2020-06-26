<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Material Dashboard by Creative Tim</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="../assets/css/material-dashboard.css?v=2.1.2"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../assets/demo/demo.css" rel="stylesheet" />
</head>
<body>
<div class="wrapper ">
	<form action="loginadmin" method="post">


		<div class="card-header card-header-primary">
			<h4 class="card-title">ADMIN LOGIN</h4>
			<p class="card-category">Complete your profile</p>
		</div>
		<div class="card-body">

			<div class="row">
				<div class="col-md-5">
					<div class="form-group"></div>
				</div>
				<div class="col-md-3">
					<div class="form-group"></div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="bmd-label-floating">Email address</label> <input
							type="email" class="form-control" name="txtAdminEmail">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group"></div>
				</div>
				<div class="col-md-6">
					<div class="form-group"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group"></div>
				</div>
				<div class="col-md-4">
					<div class="form-group"></div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="bmd-label-floating">Password</label> <input
							type="Password" class="form-control" name="txtAdminPassword">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group"></div>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary pull-right">LOGIN</button>
		<div class="clearfix"></div>
	</form>

</div>
</body>
</html>