package com.thewa.cnkart.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	// itemDetails mapping
	@OneToOne(cascade = CascadeType.ALL)
	private ItemDetails itemDetails;
	// itemReview mapping
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ItemReview> itemReview;
	// order mapping
	@ManyToMany(mappedBy = "items")
	@JsonIgnore
	private List<Order> orders;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}
	
	public List<ItemReview> getItemReview() {
		return itemReview;
	}
	
	public void setItemReview(List<ItemReview> itemReview) {
		this.itemReview = itemReview;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}