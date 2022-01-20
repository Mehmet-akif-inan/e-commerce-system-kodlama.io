package fiftWeekHomework.core;

import fiftWeekHomework.entities.concretes.Customer;
public interface GoogleService {
	void register(Customer user);
	void login(Customer user);
}
