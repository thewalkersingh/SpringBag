package com.cn.cnEvent.service;
import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {
	@Autowired
	PersonDAL personDAL;
	
	@Transactional
	public Person getPersonById(Long id) {
		Person person = personDAL.getPersonById(id);
		if (person == null)
			throw new NotFoundException("No person found");
		return person;
	}
	
	@Transactional
	public List<Person> getAllPerson() {
		List<Person> personList = personDAL.getAllPerson();
		if (personList == null)
			throw new NotFoundException("No person found");
		return personList;
	}
}