package com.trackme.spring.dao;

import java.util.List;

public interface GenericDAO<E> {

	public void persist(E e);
	public void update(E e);
	public void delete(E e);
	public List<E> getAllObjects();
	public E getObjectById(E e);
	public void saveOrUpdate(E e);
	

}
