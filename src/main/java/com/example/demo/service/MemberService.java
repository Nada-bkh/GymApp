package com.example.demo.service;

import com.example.demo.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    public Member saveOrUpdateMember(Member member);

    public List<Member> getAllMembers();

    public void deleteMember(int memberId);

}
