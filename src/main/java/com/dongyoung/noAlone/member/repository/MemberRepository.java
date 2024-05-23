package com.dongyoung.noAlone.member.repository;

import com.dongyoung.noAlone.member.entity.Member;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberById(String username);
}
