/**
 * 
 */
package com.aditya.coupans;

import java.util.Date;

/**
 * @author Aditya Kulkarni
 *
 */
public class Coupon implements Comparable<Coupon> {
	
	private String provider;
	private String name;
	private float price;
	private float discount;
	private Date exp;
	private String status;

	
	/**
	 * 
	 */
	public Coupon() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Coupon(String provider, String name, float price, float discount, Date exp, String status) {
		super();
		this.provider = provider;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.exp = exp;
		this.status = status;
	}



	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public int compareTo(Coupon o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
