package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    public MemberService memberService;

    //we use post method
    @PostMapping("/add")
    public ResponseEntity<Member> add(@RequestBody Member member) {
        Member newMember = memberService.saveOrUpdateMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    //we use post method
    @PostMapping("/getAll")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    //we use delete method
    @DeleteMapping("/delete/{memberId}")
    public String deleteMember(@PathVariable int memberId) {
        memberService.deleteMember(memberId);
        return "Membership deleted successfully";
    }

    //we use put method
    @PutMapping("/update/{memberId}")
    public Member updateMember(@PathVariable int memberId, @RequestBody Member member) {
        member.setId(memberId);
        return memberService.saveOrUpdateMember(member);
    }
}
