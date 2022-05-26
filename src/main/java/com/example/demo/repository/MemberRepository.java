package com.example.demo.repository;

import com.example.demo.dto.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return null;
    }
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

}
