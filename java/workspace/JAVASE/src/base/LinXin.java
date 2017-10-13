package base;

import javax.jws.Oneway;

public class LinXin {
	public static void main(String[] args) {
//		String[][] linxin = new String[5][9];
//		for (int j = 0; j < linxin.length; j++) {
//			
//			for (int i = j; i < linxin[0].length/2; i++) {
//				System.out.print(" ");
//			}
//			for (int i = 0; i <= 2*j; i++) {
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
//		for (int j = linxin.length-2; j >=0 ; j--) {
//			
//			for (int i = j; i < linxin[0].length/2; i++) {
//				System.out.print(" ");
//			}
//			for (int i = 0; i <= 2*j; i++) {
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
		
		//·½·¨¶þ
		int num = 10;
		String[][] x = new String[num][num];
		int xx = ((num-1)-(num-1)%2)/2;
		System.out.println(xx);
		for (int i = 0; i < num-1; i++) {
			if(i < num/2){
				for (int j = 0; j < x.length; j++) {
					if (j <= (xx + i) && j >= (xx-i)) {
						x[i][j] = "*";
					}else {
						x[i][j] = " ";
					}
				}
			}else{
				for (int j = 0; j < x.length; j++) {
					if (j <= (xx + (num - 1) - i - 1) && j >= (xx - ((num - 1) - i - 1))) {
						x[i][j] = "*";
					}else {
						x[i][j] = " ";
					}
				}
			}
		}
		for (int i = 0; i < x.length-1; i++) {
			for (int j = 0; j < x.length-1; j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
}
