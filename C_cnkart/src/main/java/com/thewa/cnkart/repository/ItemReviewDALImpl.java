package com.thewa.cnkart.repository;
import com.thewa.cnkart.dal.ItemReviewDAL;
import com.thewa.cnkart.entity.ItemReview;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemReviewDALImpl implements ItemReviewDAL {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(ItemReview review) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(review);
	}
}