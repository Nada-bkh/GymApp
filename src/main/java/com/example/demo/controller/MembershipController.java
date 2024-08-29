package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.model.Membership;
import com.example.demo.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    @Autowired
    public MembershipService membershipService;

    //we use get method
    @PostMapping("/add")
    public String add(@RequestBody Membership membership) {
        membershipService.saveOrUpdateMembership(membership);
        return "New membership is added";
    }

    //we use get method
    @PostMapping("/getAll")
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    //we use delete method
    @DeleteMapping("/delete/{membershipId}")
    public String deleteMembership(@PathVariable int membershipId) {
        membershipService.deleteMembership(membershipId);
        return "Member deleted successfully";
    }

    //we use put method
    @PutMapping("/update/{membershipId}")
    public Membership updateMembership(@PathVariable int membershipId, @RequestBody Membership membership) {
        membership.setId(membershipId);
        return membershipService.saveOrUpdateMembership(membership);
    }
}
