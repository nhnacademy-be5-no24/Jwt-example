package com.nhnacademy.auth.user.service;

import com.nhnacademy.auth.user.dto.CustomerCreateDto;
import com.nhnacademy.auth.user.entity.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);

    Customer createCustomer(CustomerCreateDto customerCreateDto);

    Customer modifyCustomer(Long id,CustomerCreateDto customerCreateDto);

}
