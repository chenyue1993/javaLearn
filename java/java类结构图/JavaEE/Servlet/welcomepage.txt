关于webapp的欢迎页面的设置：
	1、欢迎页面怎么设置？
		* 假设在WebRoot目录下创建login.html，想让login.html作为整个webapp的欢迎页面，应该做这样的设置
			编写web.xml文件：
			 <!-- 欢迎页面的设置 -->	
			  <welcome-file-list>
			    <welcome-file>index.html</welcome-file>
			  </welcome-file-list>
		* 假设在WebRoot目录下创建html目录，html目录中创建welcome.html作为整个webapp的欢迎页面，应该做这样的设置
				编写web.xml文件：
			  <!-- 欢迎页面的设置 -->	
			  <welcome-file-list>
			    <welcome-file>index.html</welcome-file>
			  </welcome-file-list>
	2、为什么设置欢迎页面？
		为了访问更方便，提高用户的体验，设置欢迎页面后，直接在浏览器地址栏上访问webapp即可
		自动定位到欢迎页面。例：http://localhost:8080/WelcomePage，直接访问的就是login.html
		
	3、欢迎页面可以配置多个，越靠上的优先级越高若资源不存在，才会访问下一个配置的欢迎页面
	
	4、欢迎页面设置的时候，路径不需要以“/”开始
	<welcome-file>index.html</welcome-file>要求在webapp的更目录下必须有一个index.html页面
	
	5、欢迎页面不一定是一个html资源，欢迎页面可以是Servlet
	
	6、欢迎页面包括全局配置和局部配置：
		全局配置：CATALINA_HOME/conf/web.xml
		局部配置：CATALINA_HOME/webapps/webapp/WEB_INF/web.xml
		注：就近原则
		若一个页面的名称是：index.html/index.htm/index.jsp，这些都是默认的欢迎页面