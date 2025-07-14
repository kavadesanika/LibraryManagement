package com.library.dao;

import com.library.model.Member;
import com.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class MemberDao {
    public void addMember(Member member) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(member);
        em.getTransaction().commit();
        em.close();
    }

    public List<Member> getAllMembers() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Member> members = em.createQuery("from Member", Member.class).getResultList();
        em.close();
        return members;
    }

    public void deleteMember(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Member member = em.find(Member.class, id);
        if (member != null) {
            em.getTransaction().begin();
            em.remove(member);
            em.getTransaction().commit();
        }
        em.close();
    }
}
