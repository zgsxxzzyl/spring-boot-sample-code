package com.service;

import com.domain.customer.Customer;
import com.domain.order.Order;
import com.exception.NoRollbackException;
import com.exception.StoreException;
import com.repository.customer.CustomerRepository;
import com.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void store(Customer customer, Order order) {
        customerRepository.save(customer);
        orderRepository.save(order);
    }

    @Transactional(rollbackFor = StoreException.class, value = "transactionManager")
    @Override
    public void storeWithStoreException(Customer customer, Order order) throws StoreException {
        customerRepository.save(customer);
        orderRepository.save(order);
        throw new StoreException();
    }

    @Transactional(noRollbackFor = NoRollbackException.class, rollbackFor = StoreException.class)
    @Override
    public void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException {
        customerRepository.save(customer);
        orderRepository.save(order);
        throw new NoRollbackException();
    }

}
