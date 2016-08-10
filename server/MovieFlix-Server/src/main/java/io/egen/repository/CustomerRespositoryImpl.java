package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.Customer;

@Repository
public class CustomerRespositoryImpl implements CustomerRespository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer findCustomer(String id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public Customer findCustomerByEmail(String emailId) {
		TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.findByEmail", Customer.class);
		query.setParameter("pEmail", emailId);
		List<Customer> customers = query.getResultList();
		if (customers != null && customers.size() == 1) {
			return customers.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.findAll", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return entityManager.merge(customer);
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		entityManager.remove(customer);
		return customer;
	}
}
