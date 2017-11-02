package beans;

public class Cat extends Animal {
	
	public static String address = "亚洲";
	//方法重写
	public void call(){
		System.out.println("小猫喵喵喵");
	}
	
	public String run(){
		return "run";
		
	}
	
	public static void eat(){
		System.out.println("吃鱼");
	}
}
