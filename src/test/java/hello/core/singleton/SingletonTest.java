package hello.core.singleton;


import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    public void pureContainer() throws Exception {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() throws Exception {
        SingletoneService instance1 = SingletoneService.getInstance();
        SingletoneService instance2 = SingletoneService.getInstance();

        System.out.println("instance1 = " + instance1); // instance1 = hello.core.singleton.SingletoneService@3b69e7d1
        System.out.println("instance2 = " + instance2); // instance2 = hello.core.singleton.SingletoneService@3b69e7d1

        Assertions.assertThat(instance1).isSameAs(instance2);
    }

}
