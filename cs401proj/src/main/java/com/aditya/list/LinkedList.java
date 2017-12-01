package com.aditya.list;

//import com.cvm.dto.CoupanDetails;

public class LinkedList<T> implements ILinkedList<T>{
	private T linkedListArray [];
	private int count;
	protected final int defaultSize = 30;
	/**
	 * @return the linkedListArray
	 */
	public T[] getLinkedListArray() {
		return linkedListArray;
	}
	/**
	 * @param linkedListArray the linkedListArray to set
	 */
	public void setLinkedListArray(T[] linkedListArray) {
		this.linkedListArray = linkedListArray;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	
	public int size() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @param linkedListArray
	 * @param count
	 */
	public LinkedList(T[] linkedListArray, int count) {
		super();
		this.linkedListArray = linkedListArray;
		this.count = count;
	}
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public LinkedList() {
		
		this.count = 0;
		this.linkedListArray = (T[]) new Object [defaultSize];
	}
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		if(this.getCount()<this.getLinkedListArray().length)
		{
			this.getLinkedListArray()[this.getCount()] = t;
			this.count++;
		}
		else
		{
			this.linkedListArray = enlarge();
			this.add(t);
		}
		
	}
	public T[] enlarge() {
		// TODO Auto-generated method stub
		int newSize = (this.getLinkedListArray().length)*2;
		// start working from here
		// add return type to enlarge function. if possible write it again
		@SuppressWarnings("unchecked")
		T newArray[] = (T[]) new Object [newSize];
		for(int i=0;i<this.getLinkedListArray().length;i++)
		{
			newArray[i] = this.getLinkedListArray()[i];
		}
		return newArray;
	}
	public void display() {
		// TODO Auto-generated method stub
		for(int i=0;i<count;i++)
		{
			System.out.println(this.getLinkedListArray()[i].toString());
		}
	}
	public T get(int i) {
		// TODO Auto-generated method stub
		
		return this.getLinkedListArray()[i];
	}
	public LinkedList<T> sort() {
		return null;
	}
	
	public T[] toArray(T[] t) {
		return linkedListArray;
	}
	
	
	
}
