package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDALImpl implements PersonDAL {
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Person getPersonById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Person.class, id);
	}
	
	@Override
	public List<Person> getAllPerson() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("FROM Person", Person.class).getResultList();
	}
}