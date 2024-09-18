package com.thewa.cnkart.repository;
import com.thewa.cnkart.dal.OrderDAL;
import com.thewa.cnkart.entity.Order;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDALImpl implements OrderDAL {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Order getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Order.class, id);
	}
	
	@Override
	public void save(Order order) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(order);
	}
	
	@Override
	public List<Order> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Order> orders = session.createQuery("from Order ", Order.class).getResultList();
		return orders;
	}
	
	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Order orderToDelete = session.get(Order.class, id);
		session.remove(orderToDelete);
	}
	
	@Override
	public void update(Order updateOrder) {
		Session session = entityManager.unwrap(Session.class);
		// fetch the current item details from the DB using id
		Order currentOrder = session.get(Order.class, updateOrder.getId());
		// update the details in the current object
		currentOrder.setOrderType(updateOrder.getOrderType());
		currentOrder.setItems(updateOrder.getItems());
		// now tell session to update db also
		session.merge(updateOrder);
	}
}