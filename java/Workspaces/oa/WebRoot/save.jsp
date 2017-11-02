<%@page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		 <meta charset="UTF-8">
		<title>保存用户信息</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/save" method="post">
			用户名：
				<input type="text" name="realname">
				<br>
			生日：
				<input type="text" name="birth">
				<br>
			性别：
				<input type="radio" name="gender" value="m">男
				<input type="radio" name="gender" value="f">女
				<br>
			联系电话：
				<input type="text" name="tel">
				<br>
			<input type="submit" value="保存">
		</form>
	</body>
</html>