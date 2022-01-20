package fiftWeekHomework;

import fiftWeekHomework.GoogleAccount.GoogleManager;
import fiftWeekHomework.business.abstracts.CustomerService;
import fiftWeekHomework.business.concretes.CustomerManager;
import fiftWeekHomework.core.GoogleManagerAdapter;
import fiftWeekHomework.dataAccess.concretes.HibernateCustomerDao;
import fiftWeekHomework.entities.concretes.Customer;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerService customerService= new CustomerManager(new HibernateCustomerDao(), 
				new GoogleManagerAdapter(new GoogleManager()));
		
		Customer customer = new Customer("mehmet ","akif","mehmet.akif@nctdata.com","123456",true);
		Customer user2 = new Customer("akif","inan","akif.inan@gmail.com","145263",false);
		CustomerService.add(customer);
		CustomerService.login(customer);
		CustomerService.confirm(customer);
		CustomerService.loginWithEmail(customer);
		CustomerService.registerWithEmail(customer);
        
		CustomerService.register(customer);
			CustomerService.login(customer);
			CustomerService.confirm(customer);
			CustomerService.loginWithEmail(customer);
			CustomerService.registerWithEmail(customer);

	

}}
