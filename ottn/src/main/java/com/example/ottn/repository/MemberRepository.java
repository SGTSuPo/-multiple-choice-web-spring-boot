package com.example.ottn.repository;

import com.example.ottn.model.Member;
import com.example.ottn.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> getAllByUserId(Long userId);
}
