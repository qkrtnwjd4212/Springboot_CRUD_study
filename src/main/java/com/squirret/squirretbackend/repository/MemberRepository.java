package com.squirret.squirretbackend.repository;

import com.squirret.squirretbackend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
