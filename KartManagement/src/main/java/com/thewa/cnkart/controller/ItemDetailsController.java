package com.thewa.cnkart.controller;
import com.thewa.cnkart.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class ItemDetailsController {
	
	@Autowired
	ItemDetailsService itemDetailsService;
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		itemDetailsService.delete(id);
	}
}