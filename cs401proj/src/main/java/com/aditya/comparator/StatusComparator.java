package com.aditya.comparator;

import java.util.Comparator;

import com.aditya.coupans.Coupon;

/**
 * Comparator class comparing over coupon status.
 * @author Aditya Kulkarni
 *
 */
public class StatusComparator implements Comparator<Coupon>{

	public StatusComparator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Total Status : Active, Used, Expired.
	 * 
	 */
	@Override
	public int compare(Coupon o1, Coupon o2) {
		// TODO Auto-generated method stub
		String s1 = o1.getStatus();
		String s2 = o2.getStatus();
		int r1 = s1.equals("Active")? 1 : s1.equals("Used")? 2 : 3;
		int r2 = s2.equals("Active")? 1 : s2.equals("Used")? 2 : 3;
		return r1 - r2;
	}

}
