package com.aditya.comparator;
import java.util.Comparator;

/**
 * 
 */
import com.aditya.coupans.Coupon;
/**
 * @author Aditya Kulkarni
 *	Comparator class comparing over coupon name.
 */
public class NameComparator implements Comparator<Coupon> {

	/**
	 * 
	 */
	public NameComparator() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public int compare(Coupon o1, Coupon o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
		//return Integer.parseInt(o1.getName().charAt(0) + "") - Integer.parseInt(o2.getName().charAt(0) + "");
	}

}
