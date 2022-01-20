package fiftWeekHomework.core;

import fiftWeekHomework.GoogleAccount.GoogleManager;
import fiftWeekHomework.entities.concretes.Customer;

public class GoogleManagerAdapter implements GoogleService{

	private GoogleManager googleManager;

	public GoogleManagerAdapter(GoogleManager googleManager) {
		this.googleManager = googleManager;
	
		
	}

	@Override
	public void register(Customer customer) {
		googleManager.register(customer);		
	}

	@Override
	public void login(Customer customer) {
		googleManager.login(customer);	
	}
}
