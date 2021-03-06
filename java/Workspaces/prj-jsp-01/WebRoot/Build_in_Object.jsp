<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
	关于JSP的九大内置对象：
		1.什么是内置对象
			可以直接在JSP中拿了直接使用的引用
		2.九大内置对象都有哪些？
			内置对象名称				           		  对应的完整类名
			------------------------------------------------------------------
			pageContext	页面范围						javax.servlet.jsp.PageContext				页面范围
			request		请求范围						javax.servlet.http.HttpServletRequest		请求范围
			session		会话范围						javax.servlet.http.HttpSession				会话范围
			appication	应用范围						javax.servlet.ServletContext				应用范围
			
			out			标准输出流						javax.servlet.jsp.JspWriter
			response	响应对象						javax.servlet.http.HttpServletResponse
			
			config		Servlet配置信息对象				javax.servlet.ServletConfig
			
			exception	异常引用(isErrorpage="true")	java.lang.Throwable
			
			page		少用							java.lang.Object[page = this;javax.servlet.http.HttpServlet]
		3.以上内置对象只能在service中直接使用，在其它方法中只能间接使用
		
		4.主要研究JSP中的四个作用域/范围对象：
			pageContext < request < session < application
			
			pageContext:在同一JSP页面中共享数据，不能跨JSP页面
			request:在同一请求中共享数据【使用较多】
			session:在同一会话中共享数据【使用较少】
			application:所有用户共享的数据可以放到应用范围中
		
	表达式:
	<% out.print(username); %> ---->   <%= username %>
--%>
<% 
	pageContext.setAttribute("pageContext", "pageContextDate");
	request.setAttribute("request", "requestDate");
	session.setAttribute("session","sessionDate");
	application.setAttribute("application", "applicationDate");
%>
<%=
	pageContext.getAttribute("pageContext")
%>
<br>
<%=
	request.getAttribute("request")
%>
<br>
<%=
	session.getAttribute("session")
%>
<br>
<%=
	application.getAttribute("application")
%>
<br>

<%
	String username = "jake";
	out.println("1.登陆成功，欢迎"+username+"回来");
%>
<br>
2.登陆成功，欢迎<% out.print(username); %>回来
<br>
3.登陆成功，欢迎<%= username %>回来
<br>
<%	out.print("pageContext -- "+pageContext);%>
<br>
<%	out.print("request -- "+request); %>
<br>
<%	out.print("session -- "+session); %>
<br>
<%	out.print("application -- "+application); %>
<br>
<%	out.print("response -- "+response); %>
<br>
<%	out.print("out -- "+out); %>
<br>
<%	out.print("config -- "+config); %>
<br>
<%	out.print("page -- "+page); %>

<html>
  <head>  
    <title>My JSP 'Build_in_Object.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
