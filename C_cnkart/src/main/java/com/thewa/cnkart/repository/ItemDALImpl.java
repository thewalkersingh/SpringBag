package com.thewa.cnkart.repository;
import com.thewa.cnkart.dal.ItemDAL;
import com.thewa.cnkart.entity.Item;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDALImpl implements ItemDAL {
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Item getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Item.class, id);
	}
	
	@Override
	public void saveItem(Item item) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(item);
	}
	
	@Override
	public List<Item> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Item> items = session.createQuery("from Item ", Item.class).getResultList();
		return items;
//      or
//		{
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
//		criteria.from(Item.class);
//		return session.createQuery(criteria).getResultList();
//		}
	}
	
	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Item itemToDelete = session.get(Item.class, id);// or getById(id);
		session.remove(itemToDelete);
	}
	
	@Override
	public void update(Item updateItem) {
		Session session = entityManager.unwrap(Session.class);
		// fetch the current item details from the DB using id
		Item currentItem = session.get(Item.class, updateItem.getId());
		// update the details in the current object
		currentItem.setDescription(updateItem.getDescription());
		currentItem.setName(updateItem.getName());
		// now tell session to update db also
		session.merge(updateItem);
	}
}