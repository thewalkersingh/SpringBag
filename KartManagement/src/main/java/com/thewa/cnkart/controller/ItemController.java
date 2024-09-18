package com.thewa.cnkart.controller;
import com.thewa.cnkart.entity.Item;
import com.thewa.cnkart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/id/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@PostMapping("/save")
	public void saveItem(@RequestBody Item item) {
		itemService.saveItem(item);
	}
	
	@GetMapping("/getAll")
	public List<Item> getAllItems() {
		return itemService.getAll();
	}
	
	@DeleteMapping("/delete/id/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteById(id);
	}
	@PutMapping("/update")
	public void updateItem(@RequestBody Item item, BindingResult bindingResult){
		itemService.updateItem(item);
	}
}