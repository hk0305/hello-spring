package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 DATA JPA
// JpaRepository를 상속하므로 Spring에 자동으로 구현체를 Bean에 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // findByName 이라는 메소드명만 사용해야하는 것은 아니다.
    // findById 등 각 멤버 네임에 맞게 정의하면,
    // JpaRepository가 알아서 구현체를 만든다.
    @Override
    Optional<Member> findByName(String name);

}
