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
		// �� kodlar� yaz�l�r.
		if(customer.getPassword().length()<6) {
			System.out.println("Password must be minimum 6 character");
			return;
		}
		final String EMAIL_REGEX ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		final Pattern pattern = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(customer.geteMail());
		 if(!matcher.matches()) {
			 System.out.println( customer.geteMail() + "L�tfen E-posta format�na uygun bir adres giriniz!");
		 }
		 for(Customer customer1:customerDao.getAll()) {
			 if(customer1.geteMail().equals(customer1.geteMail())) {
				 System.out.println("Bu E-mail adresi sistemde mevcut!.L�tfen ba�ka bir Email adresi deneyiniz!.");
			 }
			 if(customer1.getName().length()<2 && customer1.getLastName().length()<2) {
				 System.out.println("Ad ve Soyad en az 2 karakterden olu�mal�d�r!.");
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
			System.out.println("Giri� Ba�ar�l�");
			
		} else {
			System.out.println("Giri� i�lemi ba�ar�s�z!");
		}
		
	}

	@Override
	public void confirm(Customer customer) {
		if(customer.isVerify()==true) {
			customerDao.confirm(customer);
			System.out.println(customer.geteMail() + "E-mail adresiniz do�rulanm��t�r");
			
		} else {
			System.out.println(customer.geteMail() + "E-mail adresiniz do�rulanmam��t�r.");
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
			System.out.println("L�tfen Kay�t olunuz!.");
		}
		
	}

}
