package io.egen.repository;

import java.util.List;

import io.egen.entity.Customer;

public interface CustomerRespository {

	public Customer findCustomer(String id);
	
	public Customer findCustomerByEmail(String emailId);
	
	public List<Customer> findAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(Customer customer);
}
