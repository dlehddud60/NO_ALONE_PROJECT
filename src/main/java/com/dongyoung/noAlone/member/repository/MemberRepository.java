package com.dongyoung.noAlone.member.repository;

import com.dongyoung.noAlone.member.entity.Member;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberById(String username);

    Optional<Member> findByEmail(String email);
}

