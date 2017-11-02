<%@page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<title>修改用户信息</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/modify" method="post">
			用户名：
				<input type="text" name="realname" value=request.getParameter("realname")>
				<br>
			生日：
				<input type="text" name="birth" value=request.getParameter("birth")>
				<br>
			性别：
				<input type="radio" name="gender" value="m">男
				<input type="radio" name="gender" value="f">女
				<br>
			联系电话：
				<input type="text" name="tel" value=request.getParameter("tel")>
				<br>
			<input type="submit" value="修改">
		</form>
	</body>
</html>