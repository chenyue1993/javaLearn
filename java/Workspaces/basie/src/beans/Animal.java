package beans;

public class Animal {
	private String name = "����";
	public int age;
	public static String address = "����";
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void call(){
		System.out.println("���﷢�������");
	}
	
	public static void eat(){
		System.out.println("����Զ���");
	}
}