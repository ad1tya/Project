/**
 * 
 */
package com.aditya.db;

/**
 * @author Aditya Kulkarni This interface defines the common functions that all
 *         databases has to implement. I plan to complete this project with
 *         multiple databases.
 */
public interface Database<T> {
	public boolean insert(T t);
	public T remove(T t);
	public T modify(T t);
	public T[] getAll();
}
