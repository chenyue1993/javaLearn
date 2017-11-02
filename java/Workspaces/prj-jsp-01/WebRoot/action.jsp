<%@page contentType="text/html;charset=utf-8" %>
<%--
	JSP的动作：
		语法格式：<jsp:动作名 属性名=属性值 属性属性值...>
 --%>
 <%request.setAttribute("username", "lisi"); %>
 <%--转发是一次请求 --%>
 <%-- 
 <jsp:forward page="/index2.jsp"></jsp:forward>--%>
 <%-- 以上JSP的动作可以编写为对应的java程序 --%>
 <%--
 	<%request.getRequestDispatcher("/index2.jsp").forward(request,response);%>
 --%>
 <jsp:include page="/index.jsp"></jsp:include>