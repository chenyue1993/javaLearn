<%@page import="com.chenyue.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%
	List<Customer> customers = (List<Customer>)request.getAttribute("customers");
%>
<html>
	<head>
	 	<meta charset="UTF-8">
		<title>用户列表</title>
	</head>
	<body>
		<table border="1px" width="50%">
			<tr align="center">
				<th>序号</th>
				<th>姓名</th>
				<th>生日</th>
				<th>操作</th>		
			</tr>
			<%
				int i = 1;
				for(Customer customer : customers){
			%>
			<tr align="center">
				<th><%=i++ %></th>
				<th><%=customer.getRealname() %></th>
				<th><%=customer.getBirth() %></th>
				<th>
					<a href="<%=request.getContextPath()%>/detail?id=<%=customer.getId() %>">详情</a>
					<a href="<%=request.getContextPath()%>/modify.jsp?id=<%=customer.getId() %>&&birth=<%=customer.getBirth()%>&&realname=<%=customer.getRealname()%>&&gender=<%=customer.getGender()%>&&tel=<%=customer.getTel()%>">修改</a>
					<a href="<%=request.getContextPath()%>/delete?id=<%=customer.getId() %>">删除</a>
				</th>		
			</tr>
			<%		
				}
			%>
		</table>
	</body>
</html>