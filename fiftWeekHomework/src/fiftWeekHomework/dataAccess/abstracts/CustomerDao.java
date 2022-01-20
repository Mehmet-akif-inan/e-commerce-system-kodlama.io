package fiftWeekHomework.dataAccess.abstracts;

import java.util.List;

import fiftWeekHomework.entities.concretes.Customer;

public interface CustomerDao {
	public static void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	void update(Customer customer);
	void login(Customer customer);
	void delete(Customer customer);
	void register(Customer customer);
	void confirm(Customer customer);
	
	Customer get(String password);
	List<Customer> getAll();

}
