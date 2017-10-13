package base;

import java.util.ArrayList;
import java.util.Collection;

public class Ring {
	public static void main(String[] args) {
		System.out.println(getNum(100));
	}
	public static int getNum(int num){
		ArrayList<Integer> con = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			con.add(i);
			
		}
		
		int count = 1;
		for (int i = 0; con.size() != 1; i++) {
			if (i == con.size()) {
				i = 0;
				
			}
			if (count % 3 ==0) {
				con.remove(i--);
			}
			count ++;
			
		}
		return con.get(0);
	}
}
