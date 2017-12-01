/**
 * 
 */
package com.aditya.list;

import java.util.ArrayList;

import com.aditya.coupans.Coupon;

/**
 * @author Aditya Kulkarni
 *
 */
public class AllCoupons {
	private LinkedList<Coupon> list;
	private static AllCoupons instance;
	private Coupon selected;

	/**
	 * 
	 */
	private AllCoupons() {
		// TODO Auto-generated constructor stub
		list = new LinkedList<>();
	}

	public static synchronized AllCoupons getInstance() {
		if (instance == null) {
			instance = new AllCoupons();
		}
		return instance;
	}

	public void addNewCoupon(Coupon coupon) {
		list.add(coupon);
	}

	public Coupon getSelected() {
		return selected;
	}

	public void setSelected(Coupon selected) {
		this.selected = selected;
	}

	/**
	 * I will have to modify this for BST and linear search algorithm.
	 * 
	 * @param str
	 * @return
	 */
	public Coupon[] getCouponthroughName(String str) {
		ArrayList<Coupon> all = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equalsIgnoreCase(str))
				all.add(list.get(i));
		}

		//Predicate<Coupon> predicate = c -> c.getName().equalsIgnoreCase(str);
		//Coupon[] obj = (Coupon[]) list.stream().filter(predicate).collect(Collectors.toList())
	//			.toArray(new Coupon[list.size()]);
		return all.toArray(new Coupon[all.size()]);
	}

	/**
	 * 
	 * @param status
	 * @return
	 */
	public Coupon[] getCouponthroughStatus(String str) {
		ArrayList<Coupon> all = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getStatus().equalsIgnoreCase(str))
				all.add(list.get(i));
		}
		return all.toArray(new Coupon[all.size()]);
	}

	public Coupon[] getAllCoupon() {
		return list.toArray(new Coupon[list.size()]);
	}

	public LinkedList<Coupon> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	public Coupon[] getCouponthroughProvider(String text) {
		// TODO Auto-generated method stub
		ArrayList<Coupon> all = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getProvider().equalsIgnoreCase(text))
				all.add(list.get(i));
		}
		return all.toArray(new Coupon[all.size()]);
	}

	public Coupon[] getCouponthroughPriceLess(String text) {
		float num = Float.parseFloat(text);
		ArrayList<Coupon> all = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getPrice() <= num)
				all.add(list.get(i));
		}
		return all.toArray(new Coupon[all.size()]);
	}
	

	public Coupon[] getCouponthroughPriceGreater(String text) {
		float num = Float.parseFloat(text);
		ArrayList<Coupon> all = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getPrice() >= num)
				all.add(list.get(i));
		}
		return all.toArray(new Coupon[all.size()]);
	}
}
