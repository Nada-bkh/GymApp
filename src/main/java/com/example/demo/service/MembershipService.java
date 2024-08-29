package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.model.Membership;

import java.util.List;

public interface MembershipService {
    public Membership saveOrUpdateMembership(Membership membership);

    public List<Membership> getAllMemberships();

    public void deleteMembership(int membershipId);

}
