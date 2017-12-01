package com.aditya.comparator;

import java.util.Comparator;

import com.aditya.coupans.Coupon;

/**
 * 
 * @author Aditya Kulkarni
 * Comparator class comparing over coupon price.
 */
public class PriceComparator implements Comparator<Coupon>{

	public PriceComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Coupon o1, Coupon o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getPrice() - o2.getPrice());
	}

}
