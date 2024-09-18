package com.thewa.cnkart.service;
import com.thewa.cnkart.dal.ItemDAL;
import com.thewa.cnkart.dal.OrderDAL;
import com.thewa.cnkart.entity.Item;
import com.thewa.cnkart.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
	
	@Autowired
	OrderDAL orderDAL;
	@Autowired
	ItemDAL itemDAL;
	
	@Transactional
	public Order getOrderById(int id) {
		return orderDAL.getById(id);
	}
	
	@Transactional
	public void saveOrder(Order order) {
		Order saveOrder = new Order();
		saveOrder.setOrderType(order.getOrderType());
		List<Item> itemList = new ArrayList<>();
		// getting all the item details according to ID given in the order
		for (Item item : order.getItems()) {
			Item currentItem = itemDAL.getById(item.getId());
			itemList.add(currentItem);
		}
		saveOrder.setItems(itemList);
		orderDAL.save(saveOrder);
	}

	@Transactional
	public List<Order> getAllOrders() {
		return orderDAL.getAll();
	}
	
	@Transactional
	public void deleteOrderById(int id) {
		orderDAL.deleteById(id);
	}
	
	@Transactional
	public void updateOrder(Order updateOrder) {
		orderDAL.update(updateOrder);
	}
}