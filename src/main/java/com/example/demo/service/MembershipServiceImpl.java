package com.example.demo.service;

import com.example.demo.model.Membership;
import com.example.demo.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    public MembershipRepository membershipRepository;

    @Override
    public Membership addMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public void deleteMembership(int membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    @Override
    public Membership updateMembership(Membership membership) {
        return membershipRepository.save(membership);
    }
}
