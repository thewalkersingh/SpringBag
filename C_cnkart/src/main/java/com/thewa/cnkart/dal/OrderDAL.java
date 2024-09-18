package com.thewa.cnkart.dal;
import com.thewa.cnkart.entity.Order;

import java.util.List;

public interface OrderDAL {
	
	Order getById(int id);
	
	void save(Order order);
	
	List<Order> getAll();
	
	void deleteById(int id);
	
	void update(Order updateOrder);
}