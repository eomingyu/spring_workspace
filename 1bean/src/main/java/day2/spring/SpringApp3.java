package day2.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day2.review.MemberController;

public class SpringApp3 {

	public static void main(String[] args) {
		//빈 설정 파일을 읽어와서 빈(객체를) 생성합니다.spring-context가 빈을 관리합니다.
		ApplicationContext context=
				new ClassPathXmlApplicationContext
				("classpath:META-INF/spring/applicationContext3.xml");
		
		MemberController controller = (MemberController) context.getBean("memberController");
		
		controller.find(10);
	}

}
