<html data-ng-app="FormApp">
<head>
<title>Online Education Portal - Home</title>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.12/angular.min.js"></script>
<script	src="js/home.js">
	
</script>
</head>
<body data-ng-controller="FormController">
	<h1>Sing In:</h1>
	<ul>
		<li data-ng-repeat="message in messages">{{message}}</li>
	</ul>
	<div>
		<label>Email:</label> <input data-ng-model="data.email"
			type="text">
	</div>
	<div>
		<label>Password:</label> <input data-ng-model="data.password" type="password">
	</div>
	<div>
		<input data-ng-click="submit()" type="button" value="Sign In">
	</div>

</body>
</html>