package com.thewa.cnkart.service;
import com.thewa.cnkart.dal.ItemReviewDAL;
import com.thewa.cnkart.entity.ItemReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemReviewService {
	
	@Autowired
	ItemReviewDAL itemReviewDAL;
	
	@Transactional
	public void save(ItemReview review) {
		itemReviewDAL.save(review);
	}
}