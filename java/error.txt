在webapp中常见的错误代码：
	- 404  ：Not Found【资源未找到：请求路径写错了】
	- 500 ： Server Inner Error【服务器内部错误，这种情况一般都是java程序出现异常】
	404和500是HTTP协议状态代码
	以上的这些状态号是W3C制定的，所有浏览器和服务器都必须遵守，正常响应的HTTP协议状态吗：200【OK】
	<error-page>
		<error-code>500</error-code>
		<location>/error/error.html</location>
	</error-page>
路径总结：
	三类：
		第一类：以/开始，加webapp名称
		第二类：以/开始，不加webapp名称
		第三类：不以/开始，也不需要加项目名：欢迎页面