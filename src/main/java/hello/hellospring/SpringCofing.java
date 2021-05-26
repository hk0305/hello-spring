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
        // SpringDataJpaMemeberRepository가 빈에 등록되어 있으므로 그대로 사용한다.
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

//    @Bean // @ComponentScan 대신 사용 가능
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

}
