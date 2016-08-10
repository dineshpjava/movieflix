package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Customer;
import io.egen.exception.CustomerAlreadyExistsException;
import io.egen.exception.CustomerNotFoundException;
import io.egen.repository.CustomerRespository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRespository customerRepository;
	
	@Override
	public Customer findCustomer(String id) {
		return customerRepository.findCustomer(id);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAllCustomers();
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		Customer existing = customerRepository.findCustomerByEmail(customer.getEmailId());
		if(existing != null)
			throw new CustomerAlreadyExistsException("Customer with Email ID:" + existing.getEmailId() + " already exists");
		return customerRepository.createCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer existing = customerRepository.findCustomer(customer.getId());
		if(existing != null)
			return customerRepository.updateCustomer(customer);
		throw new CustomerNotFoundException("Customer with id:" + customer.getId() + " not found");
	}

	@Override
	@Transactional
	public Customer deleteCustomer(String id) {
		Customer existing = customerRepository.findCustomer(id);
		if(existing != null)
			return customerRepository.deleteCustomer(existing);
		throw new CustomerNotFoundException("Customer with id:" + id + " not found");
	}
}
