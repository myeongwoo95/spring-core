package hello.core.benfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() throws Exception {
        MemberService memberService = ac.getBean("memberService", MemberService.class); // 빈 이름으로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름 없이 타입으로만 조회")
    public void findBeanByTypeInterface() throws Exception {
        MemberService memberService = ac.getBean(MemberService.class); // 빈 타입으로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByTypeClass() throws Exception {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); //
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회가 안될경우, 실패테스트")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class)); //예외가 터져야 테스트 성공
    }

}
