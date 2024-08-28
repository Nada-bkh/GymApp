package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    public MemberService memberService;

    //we use get method
    @PostMapping("/add")
    public String add(@RequestBody Member member) {
        memberService.saveMember(member);
        return "New member is added";
    }

    //we use get method
    @PostMapping("/getAll")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    //we use delete method
    @DeleteMapping("/delete/{memberId}")
    public String deleteMember(@PathVariable int memberId) {
        memberService.deleteMember(memberId);
        return "Member deleted successfully";
    }

    //we use put method
    @PutMapping("/update/{memberId}")
    public Member updateMember(@PathVariable int memberId, @RequestBody Member member) {
        member.setId(memberId);
        return memberService.updateMember(member);
    }
}
