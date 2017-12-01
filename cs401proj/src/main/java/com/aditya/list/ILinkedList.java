package com.aditya.list;

public interface ILinkedList<T> {
	public void add(T t);
	public LinkedList<T> sort();
	public Object get(int i);
	public void display();
	public T[] enlarge();
}
