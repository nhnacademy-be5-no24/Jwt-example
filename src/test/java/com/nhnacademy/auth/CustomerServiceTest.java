package com.nhnacademy.auth;

import com.nhnacademy.auth.user.dto.CustomerCreateDto;
import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.repository.CustomerRepository;
import com.nhnacademy.auth.user.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void getCustomer() {
        //given
//        Customer customer = new Customer().builder()
//                .customerId(1L)
//                .customerPassword("123")
//                .customerName("홍길동")
//                .customerBirthday(LocalDate.of(2024,3,20))
//                .customerEmail("email@email.com")
//                .customerPhoneNumber("01098553023")
//                .customerType(true).build();
//        //when
//        when(customerRepository.findByCustomerId(1L)).thenReturn(customer);
//        Customer customer1 = customerService.getCustomer(1L);
//
//        //then
//        assertThat(customer1).isEqualTo(customer);
    }

//    @Test
//    public void createCustomer() {
//        CustomerCreateDto customerCreateDto = CustomerCreateDto.builder()
//                .customerPassword("123")
//                .customerName("홍길동")
//                .customerBirthday(LocalDate.of(2024,3,20))
//                .customerEmail("email@email.com")
//                .customerPhoneNumber("01098553023")
//                .build();
//        Customer customer = customerService.createCustomer(customerCreateDto);
//        assertThat(customer.getCustomerId()).isEqualTo(1L);
//    }


}
