package com.chenyue.test;

import com.chenyue.service.ClothesShopping;
import com.chenyue.service.ShoesShopping;
import com.chenyue.service.Shopping;

public class MyTest {
	public static void main(String[] args) {
		Shopping shoeShopping = new ShoesShopping();
		Shopping clothesShopping = new ClothesShopping();
		shoeShopping.byGoods();
		clothesShopping.byGoods();
	}
}
