package com.thewa.cnkart.service;
import com.thewa.cnkart.dal.ItemDetailsDAL;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDetailsService {
	
	@Autowired
	ItemDetailsDAL itemDetailsDAL;
	
	@Transactional
	public void delete(int id) {
		itemDetailsDAL.delete(id);
	}
}