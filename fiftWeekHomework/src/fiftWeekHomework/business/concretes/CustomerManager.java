package fiftWeekHomework.business.concretes;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.List;

import fiftWeekHomework.GoogleAccount.GoogleManager;
import fiftWeekHomework.business.abstracts.CustomerService;
import fiftWeekHomework.dataAccess.abstracts.CustomerDao;
import fiftWeekHomework.entities.concretes.Customer;


public class CustomerManager implements CustomerService{
	private CustomerDao customerDao;
	private GoogleManager service;

	public CustomerManager(CustomerDao customerDao, GoogleManager googleservice) {
		super();
		this.customerDao = customerDao;
	} 

	@Override
	public void add(Customer customer) {
		// Ýþ kodlarý yazýlýr.
		if(customer.getPassword().length()<6) {
			System.out.println("Password must be minimum 6 character");
			return;
		}
		final String EMAIL_REGEX ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		final Pattern pattern = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(customer.geteMail());
		 if(!matcher.matches()) {
			 System.out.println( customer.geteMail() + "Lütfen E-posta formatýna uygun bir adres giriniz!");
		 }
		 for(Customer customer1:customerDao.getAll()) {
			 if(customer1.geteMail().equals(customer1.geteMail())) {
				 System.out.println("Bu E-mail adresi sistemde mevcut!.Lütfen baþka bir Email adresi deneyiniz!.");
			 }
			 if(customer1.getName().length()<2 && customer1.getLastName().length()<2) {
				 System.out.println("Ad ve Soyad en az 2 karakterden oluþmalýdýr!.");
			 }
		 }
		 CustomerDao.add(customer);
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(Customer customer) {
		if(customer.isVerify() == true) {
			customerDao.login(customer);
			System.out.println("Giriþ Baþarýlý");
			
		} else {
			System.out.println("Giriþ iþlemi baþarýsýz!");
		}
		
	}

	@Override
	public void confirm(Customer customer) {
		if(customer.isVerify()==true) {
			customerDao.confirm(customer);
			System.out.println(customer.geteMail() + "E-mail adresiniz doðrulanmýþtýr");
			
		} else {
			System.out.println(customer.geteMail() + "E-mail adresiniz doðrulanmamýþtýr.");
		}
		
	}

	@Override
	public void registerWithEmail(Customer customer) {
		customer.setVerify(true);
		this.service.register(customer);
		
	}

	@Override
	public void loginWithEmail(Customer customer) {
		if(customer.isVerify() == true) {
			this.service.login(customer);
		}
		else {
			System.out.println("Lütfen Kayýt olunuz!.");
		}
		
	}

}
