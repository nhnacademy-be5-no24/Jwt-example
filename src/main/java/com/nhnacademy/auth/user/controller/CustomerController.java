package com.nhnacademy.auth.user.controller;

import com.nhnacademy.auth.user.dto.CustomerCreateDto;
import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer/create")
    public Customer createCustomer(@RequestBody CustomerCreateDto customerCreateDto) {
        return customerService.createCustomer(customerCreateDto);
    }

    @PutMapping("/customer/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody CustomerCreateDto customerCreateDto) {
        return customerService.modifyCustomer(id, customerCreateDto);
    }

    //로그인 확인을 위한 home화면
    @GetMapping("/")
    public @ResponseBody String home() {
        return "home";
    }

    //로그인 확인을 위한 로그인폼
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

}
