package fiftWeekHomework.business.abstracts;

import java.util.List;

import fiftWeekHomework.entities.concretes.Customer;

public interface CustomerService {
	void add(Customer customer);
	void login(Customer customer);
	void confirm(Customer customer);
	void registerWithEmail(Customer customer);
	void loginWithEmail(Customer customer);
	List<Customer> getAll() ;
}
