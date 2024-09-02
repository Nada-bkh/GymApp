package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.model.Membership;
import com.example.demo.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    public MemberRepository memberRepository;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Member saveOrUpdateMember(Member member) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        // Fetch the existing Member object from the database
        Member existingMember = em.find(Member.class, member.getId());

        if (existingMember != null) {
            // Update the existing Member object
            existingMember.setMembershipList(member.getMembershipList());
        } else {
            // Create a new Member object
            em.persist(member);
        }

        em.getTransaction().commit();
        em.close();

        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(int memberId) {
        memberRepository.deleteById(memberId);
    }

}
