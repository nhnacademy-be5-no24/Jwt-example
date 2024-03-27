package com.nhnacademy.auth.user.service.impl;

import com.nhnacademy.auth.user.dto.MemberCreateDto;
import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.entity.Grade;
import com.nhnacademy.auth.user.entity.Member;
import com.nhnacademy.auth.user.repository.CustomerRepository;
import com.nhnacademy.auth.user.repository.GradeRepository;
import com.nhnacademy.auth.user.repository.MemberRepository;
import com.nhnacademy.auth.user.service.GradeService;
import com.nhnacademy.auth.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CustomerRepository customerRepository;
    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;
    private final GradeService gradeService;

    @Override
    public Member getMember(Long id) {
        Customer customer = customerRepository.findByCustomerNo(id);
        Member member = memberRepository.findByCustomer(customer);
        return member;
    }

    @Override
    public Member createMember(MemberCreateDto memberCreateDto) {
        String rawPassword = memberCreateDto.getCustomerPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        Customer customer = new Customer();
        customer.setCustomerId(memberCreateDto.getCustomerId());
        customer.setCustomerPassword(encPassword);
        customer.setCustomerName(memberCreateDto.getCustomerName());
        customer.setCustomerPhoneNumber(memberCreateDto.getCustomerPhoneNumber());
        customer.setCustomerEmail(memberCreateDto.getCustomerEmail());
        customer.setCustomerBirthday(memberCreateDto.getCustomerBirthday());
        customer.setCustomerRole("ROLE_MEMBER"); //비회원 회원가입 false 회원 회원가입 true
        customer = customerRepository.save(customer);
        log.info("{}",customer.toString());

        Member member = new Member();
        member.setCustomerNo(customer.getCustomerNo());
        member.setCustomer(customer);
        member.setMemberId(memberCreateDto.getCustomerId());
        member.setLastLoginAt(LocalDateTime.now());
        Grade grade = gradeService.getGrade(memberCreateDto.getGradeId());
        member.setGrade(grade);
        member.setIsLeave(false);
        member.setIsActive(true);
        member.setRole("ROLE_MEMBER");
        return memberRepository.save(member);
    }

    @Override
    public Member modifyMember(Long id, MemberCreateDto memberCreateDto) {
        String rawPassword = memberCreateDto.getCustomerPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        Customer customer = customerRepository.findByCustomerNo(id);
        customer.setCustomerId(memberCreateDto.getCustomerId());
        customer.setCustomerPassword(encPassword);
        customer.setCustomerName(memberCreateDto.getCustomerName());
        customer.setCustomerPhoneNumber(memberCreateDto.getCustomerPhoneNumber());
        customer.setCustomerEmail(memberCreateDto.getCustomerEmail());
        customer.setCustomerBirthday(memberCreateDto.getCustomerBirthday());
        customer.setCustomerRole("ROLE_MEMBER"); //비회원 회원가입 false 회원 회원가입 true
        customer = customerRepository.save(customer);

        Member member = memberRepository.findByCustomer(customer);
        member.setCustomerNo(customer.getCustomerNo());
        member.setCustomer(customer);
        member.setMemberId(memberCreateDto.getCustomerId());
        Grade grade = gradeService.getGrade(memberCreateDto.getGradeId());
        member.setGrade(grade);
        member.setIsLeave(false);
        member.setIsActive(true);
        member.setRole("ROLE_MEMBER");
        return memberRepository.save(member);
    }


    @Override
    public Member deleteMember(Long id) {
        Customer customer = customerRepository.findByCustomerNo(id);
        Member member = memberRepository.findByCustomer(customer);
        member.setIsLeave(true);
        return memberRepository.save(member);
    }
}
