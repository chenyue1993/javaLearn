package beans;

public class Animal {
	private String name = "可乐";
	public int age;
	public static String address = "非洲";
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void call(){
		System.out.println("动物发出吼叫声");
	}
	
	public static void eat(){
		System.out.println("动物吃东西");
	}
}
