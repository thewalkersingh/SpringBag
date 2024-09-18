package com.example.todocrud.services;
import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices {
	@Autowired
	UserServices userServices;
	@Autowired
	ToDoRepository toDoRepository;
	@Autowired
	UserRepository userRepository;
	
	public Todo getTodoById(Long todoId) {
		// write code
		Optional<Todo> todo = toDoRepository.findById(todoId);
		return todo.get();
	}
	
	public void addTodo(Long userId, Todo todo) {
		// write code
		Users user = userServices.getUserById(userId);
		user.getTodoList().add(todo);
		userRepository.save(user);
		toDoRepository.save(todo);
	}
	
	public void deleteTodo(Long userId, Long todoId) {
		Users user = userServices.getUserById(userId);
//		List<Todo> allTodo = user.getTodoList();
//		Todo singleTodo = getTodoById(todoId);
//		for (Todo todo : allTodo) {
//			if (todo.getId() == singleTodo.getId()) {
//				toDoRepository.delete(todo);
//			}
//		}
		userRepository.save(user);
		user.getTodoList().removeIf(existingTodo -> existingTodo.getId() == todoId);
		userRepository.save(user);
		toDoRepository.deleteById(todoId);
	}
	
	public void toggleTodoCompleted(Long todoId) {
		Todo todo = this.getTodoById(todoId);
		todo.setCompleted(!todo.getCompleted());
		toDoRepository.save(todo);
	}
	
	public void updateTodo(Todo todo) {
		if (toDoRepository.existsById(todo.getId())) {
			toDoRepository.save(todo);
		}
	}
}