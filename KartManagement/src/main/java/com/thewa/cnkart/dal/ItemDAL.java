package com.thewa.cnkart.dal;
import com.thewa.cnkart.entity.Item;

import java.util.List;

public interface ItemDAL {
	
	Item getById(int id);
	
	void saveItem(Item item);
	
	List<Item> getAll();
	
	void deleteById(int id);
	
	void update(Item updateItem);
}