package fiftWeekHomework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import fiftWeekHomework.dataAccess.abstracts.CustomerDao;
import fiftWeekHomework.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao{
	
	  List <Customer> customer = new ArrayList<Customer> ();

	public void add(Customer customer) {
		System.out.println("Added User " + customer.getName() + customer.getLastName());
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Updated User " + customer.getName() + customer.getLastName());
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Deleted User " + customer.getName() + customer.getLastName());
	}

	@Override
	public Customer get(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return this.customer;
	}

	@Override
	public void login(Customer customer) {
		System.out.println(customer.getName() + customer.getLastName() + "isimli kullanýcý giriþ yaptý!");		
	}

	@Override
	public void register(Customer customer) {
		System.out.println(customer.getName() + customer.getLastName() + "isimli kullanýcý kayýt yaptý!");		
	}

	@Override
	public void confirm(Customer customer) {
		System.out.println(customer.getName() + customer.getLastName() + "isimli kullanýcý onaylandý yaptý!");		
	}

}
