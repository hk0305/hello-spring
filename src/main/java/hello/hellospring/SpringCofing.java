package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringCofing {

      /* JPA를 사용하지 않는 경우 */
//    private DataSource dataSource;
//    @Autowired
//    public SpringCofing(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    /* JPA를 사용하는 경우 */
//    private EntityManager em;
//    @Autowired
//    public SpringCofing(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringCofing(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 자바 코드로 직접 Bean에 등록하기 */
    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        // SpringDataJpaMemberRepository가 빈에 등록되어 있으므로 그대로 사용한다.
        return new MemberService(memberRepository);
    }

    /**
     * 아래 전체 주석을 한 이유는?
     * SpringDataJpaMemberRepository에 JpaRepository를 상속하므로
     * 자동으로 Spring Cotainer에 Bean으로 등록된다.
     * 또한, 단순한 인터페이스만으로도 공통적으로 사용하는 JDBC 과정을
     * 두 줄로 사용할 수 있다는 점에서 편리하다.
     * 단, 모든 쿼리가 공통적으로 사용이 되는 건 아니므로
     * 정말 공통적으로 쿼리들을 JDBC 할 때 만 사용하는 한계가 있다.
     */
//    @Bean
//    public MemberRepository memberRepository() {
            // Map객체에 담아서 서버가 돌아가는 동안 저장
//        return new MemoryMemberRepository();
            // DB에 직접 연결하여 데이터 저장
//        return new JdbcMemberRepository(dataSource);
            // JdbcTemplate를 사용한 데이터 저장
//        return new JdbcTemplateMemberRepository(dataSource);
            // JPA를 사용한 데이터 저장
//        return new JpaMemberRepository(em);
//    }

//    @Bean // @ComponentScan 대신 사용 가능
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

}
