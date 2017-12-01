package com.aditya.comparator;

import java.util.Comparator;

import com.aditya.coupans.Coupon;

/**
 * Comparator class comparing over coupon final price.
 * @author Pravin Kulkarni
 *
 */
public class FinalComparator implements Comparator<Coupon>{

	public FinalComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Coupon o1, Coupon o2) {
		// TODO Auto-generated method stub
		float total_price1 = (o1.getPrice() - (o1.getPrice() * (o1.getDiscount() / 100)));
		float total_price2 = (o2.getPrice() - (o2.getPrice() * (o2.getDiscount() / 100)));
		return (int) ((total_price1 - total_price2)*100);
	}

}
