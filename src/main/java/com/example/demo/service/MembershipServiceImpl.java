package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.model.Membership;
import com.example.demo.repository.MembershipRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    public MembershipRepository membershipRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Membership saveOrUpdateMembership(Membership membership) {
        // Fetch the existing Member object from the database
        Member member = entityManager.find(Member.class, membership.getMember().getId());

        if (member != null) {
            // Update the existing Member object
            member.getMembershipList().add(membership);
            membership.setMember(member);
            entityManager.merge(member);
        } else {
            // Handle the case where the Member object is not found
            throw new RuntimeException("Member not found");
        }

        return membership;
    }

    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public void deleteMembership(int membershipId) {
        membershipRepository.deleteById(membershipId);
    }

}
