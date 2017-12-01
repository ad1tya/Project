package com.aditya.comparator;

import java.util.Comparator;

import com.aditya.coupans.Coupon;

/**
 * Comparator class comparing over coupon discount.
 * @author Pravin Kulkarni
 *
 */
public class DiscountComparator  implements Comparator<Coupon>{

	public DiscountComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Coupon o1, Coupon o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getDiscount() - o2.getDiscount());
	}
}
