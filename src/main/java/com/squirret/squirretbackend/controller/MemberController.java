package com.squirret.squirretbackend.controller;

import com.squirret.squirretbackend.domain.Member;
import com.squirret.squirretbackend.dto.MemberRequestDto;
import com.squirret.squirretbackend.dto.MemberResponseDto;
import com.squirret.squirretbackend.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public MemberResponseDto createMember(@RequestBody MemberRequestDto requestDto) {
        Member saved = memberService.saveMember(requestDto);
        return new MemberResponseDto(saved);
    }

    @GetMapping
    public List<MemberResponseDto> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return members.stream()
                .map(MemberResponseDto::new) // 생성자 참조 문법: new MemberResponseDto(member)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {
        Member member = memberService.getMember(id);
        return new MemberResponseDto(member);
    }

    @PutMapping("/{id}")
    public MemberResponseDto updateMember(@PathVariable Long id, @RequestBody MemberRequestDto requestDto) {
        Member updated = memberService.updateMember(id, requestDto);
        return new MemberResponseDto(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }


}
