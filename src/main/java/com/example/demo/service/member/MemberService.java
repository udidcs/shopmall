package com.example.demo.service.member;

import com.example.demo.dto.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(Member member) {
        repository.save(member);
    }

//    Member findMember(Long memberId) {
//
//    }




}
