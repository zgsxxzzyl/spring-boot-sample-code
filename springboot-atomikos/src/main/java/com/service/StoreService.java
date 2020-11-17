package com.service;

import com.domain.customer.Customer;
import com.domain.order.Order;
import com.exception.NoRollbackException;
import com.exception.StoreException;

public interface StoreService {

    void store(Customer customer, Order order) throws Exception;

    void storeWithStoreException(Customer customer, Order order) throws StoreException;

    void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException;

    public void storeWithUnChecked(Customer customer, Order order);

}