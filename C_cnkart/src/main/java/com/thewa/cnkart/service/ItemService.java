package com.thewa.cnkart.service;
import com.thewa.cnkart.dal.ItemDAL;
import com.thewa.cnkart.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
	
	@Autowired
	ItemDAL itemDAL;
	
	@Transactional
	public Item getItemById(int id) {
		return itemDAL.getById(id);
	}
	
	@Transactional
	public void saveItem(Item item) {
		itemDAL.saveItem(item);
	}
	
	@Transactional
	public List<Item> getAll() {
		return itemDAL.getAll();
	}
	
	@Transactional
	public void deleteById(int id) {
		itemDAL.deleteById(id);
	}
	
	@Transactional
	public void updateItem(Item item) {
		itemDAL.update(item);
	}
}