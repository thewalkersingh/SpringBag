package com.example.cnExpense.DAL;
import com.example.cnExpense.entities.ExpenseType;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.IncomeType;
import com.example.cnExpense.entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDalImpl implements UserDal {
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<User> getAllUsers() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from User ", User.class).getResultList();
	}
	
	@Override
	public User getUserById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(User.class, id);
	}
	
	@Override
	public void saveUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
	}
	
	@Override
	public boolean checkUserExist(User user) {
		boolean userExist = false;
		for (User everyUser : getAllUsers()) {
			if (everyUser.getUsername().equalsIgnoreCase(user.getUsername())) {
				userExist = true;
				break;
			}
		}
		return userExist;
	}
	
	@Override
	public List<User> filterUserListByCalendar(String day, String month, String year) {
		List<User> filteredList = new ArrayList<>();
		List<User> userList = getAllUsers();
		for (User user : userList) {
			List<Income> filteredIncomes = new ArrayList<>();
			for (Income income : user.getIncomes()) {
				if ((income.getDate() != null) &&
				    (day != null && !day.isEmpty() && !(Integer.parseInt(day) == income.getDate().getDayOfMonth()))) {
					continue;
				}
				else if ((income.getDate() != null) &&
				         (month != null && !month.isEmpty() &&
				          !(Integer.parseInt(month) == income.getDate().getMonthValue()))) {
					continue;
				}
				else if ((income.getDate() != null) &&
				         (year != null && !year.isEmpty() && !(Integer.parseInt(year) == income.getDate().getYear()))) {
					continue;
				}
				filteredIncomes.add(income);
			}
			user.setIncomes(filteredIncomes);
			filteredList.add(user);
		}
		return filteredList;
	}
	
	@Override
	public List<User> filterUserListByType(String incomeType, String expenseType) {
		List<User> userList = getAllUsers();
		List<User> filteredList = new ArrayList<>();
		for (User user : userList) {
			List<Income> filteredIncomes = new ArrayList<>();
			for (Income income : user.getIncomes()) {
				if (incomeType != null && !incomeType.isEmpty()) {
					boolean foundIncomeType = false;
					for (IncomeType type : income.getIncomeTypes()) {
						if (type.getName().equalsIgnoreCase(incomeType)) {
							foundIncomeType = true;
							break;
						}
					}
					if (!foundIncomeType) {
						continue;
					}
				}
				else if (expenseType != null && !expenseType.isEmpty()) {
					boolean foundExpenseType = false;
					for (ExpenseType type : income.getExpense().getExpenseTypes()) {
						if (type.getName().equalsIgnoreCase(expenseType)) {
							foundExpenseType = true;
							break;
						}
					}
					if (!foundExpenseType) {
						continue;
					}
				}
				filteredIncomes.add(income);
			}
			user.setIncomes(filteredIncomes);
			filteredList.add(user);
		}
		return filteredList;
	}
}