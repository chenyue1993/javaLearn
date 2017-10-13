package com.chenyue.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>                                   ");
		out.print("	<head>                                  ");
		out.print("		<title>This is a test Code</title>  ");
		out.print("	</head>                                 ");
		out.print("	<body>                                  ");
		out.print("		This is a test code <br> LoginSuccess!                 ");
		out.print("	</body>                                 ");
		out.print("</html>                                  ");
		                                                   

	}

}
