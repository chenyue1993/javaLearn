adapter适配器
1、程序不使用缺省适配器的缺点：
	程序中A,B,C类只需要使用Servlet接口中的m1,m2,m3方法，让这些类直接实现这个接口，需要实现更多方法，代码丑陋

2、写一个抽象类Adapter，将A，B，C中要用的方法定义成abstract方法，用A，B，C继承adapter

设计模式的分类：
	创建型：解决对象的创建问题
	行为型：该模式与方法、行为、算法有关的设计模式
	结构型：更多类，更多对象组合成更大的结构解决某个特定的问题
	
你听过哪些设计模式？
	- Gof95（1995年，四人组提出的23种设计模式）
	*单例模式
	*工厂模式
	*迭代器模式【集合】
	*策略模式【集合】
	*装饰器模式【IO流】
	。。。。。。
	
	- javaEE设计模式
	。。。。。。
	
3、我们目前所有的Servlet类直接实现了javax.servlet.Servlet接口，但这个接口中很多方法是目前
	不需要，我们可能只需要编写service。直接实现Servlet接口代码丑陋，有必要在中间添加一个适配器
	以后所有的Servlet类不在直接实现Servlet接口，应去继承适配器类。
	
	适配器可以让代码优雅之外，还可以在适配器中提供大量的方法，子类继承以后，可以在子类中直接使用，方便编程
	若在初始化时需要执行一段特殊的代码，不希望重新init(ServletConfig config)方法，太丑陋
	public final void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}
	public void init(){
		
	}