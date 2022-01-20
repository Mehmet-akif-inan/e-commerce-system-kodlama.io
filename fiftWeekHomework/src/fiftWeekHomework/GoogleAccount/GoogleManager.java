package fiftWeekHomework.GoogleAccount;

import fiftWeekHomework.business.concretes.CustomerManager;
import fiftWeekHomework.entities.concretes.Customer;

public class GoogleManager {
	
	public void register(Customer customer) {
		System.out.println(customer.getName()+""+ customer.getLastName()+" siteye kaydoldunuz.");
	}
	public void login(Customer customer) {
		System.out.println(customer.getName()+""+ customer.getLastName()+" siteye giris yaptýnýz.");
	}
}
