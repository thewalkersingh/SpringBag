package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Person;

import java.util.List;

public interface PersonDAL {
	Person getPersonById(Long id);
	
	List<Person> getAllPerson();
}