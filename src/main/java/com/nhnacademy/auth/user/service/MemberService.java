package com.nhnacademy.auth.user.service;

import com.nhnacademy.auth.user.dto.MemberCreateDto;
import com.nhnacademy.auth.user.entity.Member;

public interface MemberService {
    Member getMember(Long id);
    Member createMember(MemberCreateDto memberCreateDto);

    Member modifyMember(Long id,MemberCreateDto memberCreateDto);

    Member deleteMember(Long id);
}
