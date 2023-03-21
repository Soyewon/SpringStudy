package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장소에 저장

    Optional<Member> findById(Long id);

    //* Optional - Null일때와 아닐 때 둘 다 있을 수 있으므로 Optional로 처리
    Optional<Member> findByName(String name);

    List<Member> findAll(); // 지금까지 저장된 모든 회원들 반환
}
