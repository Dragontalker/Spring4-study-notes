package com.dragontalker.springdemo.dao;

import java.util.List;

import com.dragontalker.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}