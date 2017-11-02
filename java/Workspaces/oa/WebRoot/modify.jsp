<%@page contentType="text/html;charset=utf-8"%>
<html>
	<head>
	 	<meta charset="UTF-8">
		<title>修改用户信息</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/modify" method="post">
		<%String id = request.getParameter("id");
			System.out.println("id="+id);
		%>
		<%session.setAttribute("id", id); %>
			用户名：
				<input type="text" name="realname" value=<%=request.getParameter("realname")%>>
				<br>
			生日：
				<input type="text" name="birth" value=<%=request.getParameter("birth")%>>
				<br>
			性别：
				<input type="radio" name="gender" value="m">男
				<input type="radio" name="gender" value="f">女
				<br>
			联系电话：
				<input type="text" name="tel" value=<%=request.getParameter("tel")%>>
				<br>
			<input type="submit" value="修改">
		</form>
	</body>
</html>