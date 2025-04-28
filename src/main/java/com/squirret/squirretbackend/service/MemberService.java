package com.squirret.squirretbackend.service;

import com.squirret.squirretbackend.domain.Member;
import com.squirret.squirretbackend.dto.MemberRequestDto;
import com.squirret.squirretbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository, MemberRepository memberRepository1) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member saveMember(MemberRequestDto dto) {
        Member member = new Member(dto.getName(), dto.getEmail());
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id){
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }

    @Transactional
    public Member updateMember(Long id, MemberRequestDto dto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        member.update(dto.getName(), dto.getEmail());
        return memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}




