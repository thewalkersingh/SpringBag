package com.example.todocrud.entity;
import jakarta.persistence.*;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String content;
	private Boolean completed = false;
//	@ManyToOne(fetch=FetchType.EAGER)  // Many todos belong to one user
//	@JoinColumn(name="user_id")       // Foreign key column
//	private Users user;
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Boolean getCompleted() {
		return completed;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
}