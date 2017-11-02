<%@page contentType="text/html;charset=utf-8"%>
<%-- 
	关于JSP的指令：
		1.作用：指导JSP的翻译引擎如何翻译JSP代码
		2.JSP中共有三个指令：
			- page
			- include
			- taglib
		3.指令的使用语法格式：
			<%@指令名 属性名=属性值 属性名=属性值...%>
		4.关于JSP的page指令，page指令常用的属性：
			在public void _jspservice(final javax.servlet.servlet.http.HttpServletRequest,
					final javax.servlet.servlet.http.HttpServletResponse) 
					throws java.io.IOExcept,javax.servlet.ServletException{}方法中
					
			- contentType	设置JSP的响应内容类型，同时在后面也可以指定字符编码方式		
			- pageEncoding	设置JSP的响应时的字符编码方式
				//	response.setContentType("text/html;charset=utf-8");
			- import		组织导入		导入包import="java.util.*,java..."
			
			- session		设置当前JSP页面中是否可以直接使用session内置对象     session="false"不会自动创建session对象
				//	session = pageContext.getSession();  JSP默认会有session对象，没有会创建session对象
				//  如果session="false"时要用session
				<%HttpSession session = request.getSession(false);%>
			- errorPage		错误页面		errorPage="/error.html"
				//	当前页面出错后会跳转到error.html
			- isErrorPage	是否是错误页面	isErrorPage="ture"
				//	当前页面中可以使用内置对象exception引用
			- isELIgnored	是否忽略EL表达式
			
		5.关于JSP的include指令，include指令常用的属性：
			非常重要：
				1.a.jsp可以将b.jsp包含进来，
				2.作用：
				全网页中有一些主体框架，例如：网页头，网页脚，这些都是不变的，我们可以将这些编写到某个jsp中在需要的时候
				使用include指令包含进来
				优点：代码量少，便于维护【修改一个文件可以作用于所有的页面】，
				3.在一个jsp中可以使用多个include命令
			- file="/index.html"  写路径将重复的代码直接写到路径中
		6.include实现原理：
			1.编译期包含
			2.a.jsp包含b.jsp，底层生成一个java源文件，一个class字节码文件，翻译期包含/编译期包含/静态联编
		7.静态联编的时候，多个jsp中可以共享一个局部变量
--%>
