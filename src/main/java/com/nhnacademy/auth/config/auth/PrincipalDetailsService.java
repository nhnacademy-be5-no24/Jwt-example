package com.nhnacademy.auth.config.auth;

import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.entity.Member;
import com.nhnacademy.auth.user.repository.CustomerRepository;
import com.nhnacademy.auth.user.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginprocessingurl("/login);
//login 요청이 오면 자동으로 UserDetailService 타입으로 ioc되어 이쓴ㄴ loadUserByUsername 함수가 실행됨.
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCustomerId(username);
        Member member = memberRepository.findByCustomer(customer);

        log.info("username:{}",username);
        log.info("member:{}", member);

        if (member != null) {
            return new PrincipalDetails(member);
        }
        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다." + username);
    }
}
