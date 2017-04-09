package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Customer;
import io.egen.service.CustomerService;

@RestController
@RequestMapping(path="/customers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public Customer findCustomer(@PathVariable("id") String id){
		return customerService.findCustomer(id);		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> findAllCustomers(){
		return customerService.findAllCustomers();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Customer createCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") String id){
		return customerService.updateCustomer(customer);		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="/{id}")
	public Customer deleteCustomer(@PathVariable("id") String id){
		return customerService.deleteCustomer(id);
	}
}