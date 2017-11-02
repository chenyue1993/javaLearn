package test;

import beans.Animal;
import beans.Cat;

public class Test {
	
	public static void main(String[] args) {
		Animal.eat();
		Cat.eat();
		
		System.out.println(Cat.address);
		System.out.println(Animal.address);
		
		Cat cat = new Cat();
		cat.setName("雪碧");
		System.out.println(cat.getName());
		
		Animal animal = new Animal();
		System.err.println(animal.getName());
		
		//向上转型
		Animal animal1 = new Cat();
		if (animal1 instanceof Cat) {
			System.out.println(((Cat) animal1).run());
		}
		if (animal instanceof Cat) {
			System.out.println(((Cat) animal).run());
		}
		
		Animal a = new Cat();
		if (a instanceof Cat) {
			((Cat) a).eat();
		}
	}
}
