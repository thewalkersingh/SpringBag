package com.thewa.cnkart.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "itemreview")
public class ItemReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String reviewerName;
	@Column
	private String review;
	@ManyToOne
	@JoinColumn(name = "item_Id")
	@JsonBackReference
	private Item item;
	
	public int getId() {
		return id;
	}
	
	public String getReviewerName() {
		return reviewerName;
	}
	
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
}