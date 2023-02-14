package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; //우리가 사용하는 jpa 라이브러리에서 다 자동으로 생성해준다.

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); //김영한 의견 : 저장하는 경우에는 리턴 값을 반환하지 않는다.
        //사이드 이펙트가 발생 할 수있기 때문에
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
