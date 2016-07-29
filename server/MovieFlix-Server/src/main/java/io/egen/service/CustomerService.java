package io.egen.service;

import java.util.List;

import io.egen.entity.Customer;

public interface CustomerService {

	public Customer findCustomer(String id);
	
	public List<Customer> findAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(String id);
}
