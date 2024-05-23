package com.dongyoung.noAlone.mbti.repository;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MbtiRepository extends JpaRepository<Mbti,Long> {
    Mbti findByMbtiId(Long mbtiId);
    Mbti findByName(String name);
}
