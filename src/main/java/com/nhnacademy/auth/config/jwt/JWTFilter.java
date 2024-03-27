package com.nhnacademy.auth.config.jwt;

import com.nhnacademy.auth.config.auth.PrincipalDetails;
import com.nhnacademy.auth.user.entity.Customer;
import com.nhnacademy.auth.user.entity.Member;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {

        this.jwtUtil = jwtUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //request에서 Authorization 헤더를 찾음
        String authorization= request.getHeader("Authorization");

        //Authorization 헤더 검증
        if (authorization == null || !authorization.startsWith("Bearer ")) {

            System.out.println("token null");
            filterChain.doFilter(request, response);

            //조건이 해당되면 메소드 종료 (필수)
            return;
        }

        String token = authorization.split(" ")[1];

        //토큰 소멸 시간 검증
        if (jwtUtil.isExpired(token)) {

            System.out.println("token expired");
            filterChain.doFilter(request, response);

            //조건이 해당되면 메소드 종료 (필수)
            return;
        }


        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        Customer customer = new Customer();
        customer.setCustomerPassword("tempPassword");
        customer.setCustomerRole(role);

        Member member = new Member();
        member.setMemberId(username);
        member.setRole(role);
        member.setCustomer(customer);

        PrincipalDetails principalDetails = new PrincipalDetails(member);

        Authentication authToken = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }

}
