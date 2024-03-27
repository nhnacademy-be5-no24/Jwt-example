package com.nhnacademy.auth.user.service.impl;

import com.nhnacademy.auth.user.dto.CustomerCreateDto;
import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.repository.CustomerRepository;
import com.nhnacademy.auth.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findByCustomerNo(id);
    }

    @Transactional
    @Override
    public Customer createCustomer(CustomerCreateDto customerCreateDto) {
        String rawPassword = customerCreateDto.getCustomerPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        Customer customer = new Customer();
        customer.setCustomerId(customerCreateDto.getCustomerId());
        customer.setCustomerPassword(encPassword);
        customer.setCustomerName(customerCreateDto.getCustomerName());
        customer.setCustomerPhoneNumber(customerCreateDto.getCustomerPhoneNumber());
        customer.setCustomerEmail(customerCreateDto.getCustomerEmail());
        customer.setCustomerBirthday(customerCreateDto.getCustomerBirthday());
        customer.setCustomerRole("ROLE_CUSTOMER"); //비회원 회원가입 false 회원 회원가입 true
        return customerRepository.save(customer);
    }
    @Transactional
    @Override
    public Customer modifyCustomer(Long id,CustomerCreateDto customerCreateDto) {
        String rawPassword = customerCreateDto.getCustomerPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        Customer customer = customerRepository.findByCustomerNo(id);
        customer.setCustomerId(customerCreateDto.getCustomerId());
        customer.setCustomerPassword(encPassword);
        customer.setCustomerName(customerCreateDto.getCustomerName());
        customer.setCustomerPhoneNumber(customerCreateDto.getCustomerPhoneNumber());
        customer.setCustomerEmail(customerCreateDto.getCustomerEmail());
        customer.setCustomerBirthday(customerCreateDto.getCustomerBirthday());
        return customerRepository.save(customer);
    }
}
