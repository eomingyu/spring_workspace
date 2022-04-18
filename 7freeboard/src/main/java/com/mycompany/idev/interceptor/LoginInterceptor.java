package com.mycompany.idev.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.idev.controller.TestLoginController;
import com.mycompany.idev.dto.Administrator;
import com.mycompany.idev.dto.Member;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(TestLoginController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("[request URL]{}",request.getRequestURL());
		log.info("[request URI]{}",request.getRequestURI());

		String url=request.getContextPath();

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		Administrator admin = (Administrator) session.getAttribute("admin");
		//  /member/list.do 는 admin 세션애트리뷰트가 null이 아닐때만 요청 실행하기
		//			ㄴ 그렇지 않으면 alert 띄우기
		if(request.getRequestURI().equals(url+"/member/list.do") && admin==null) {
			String msg="관리자 로그인 하세요.";
			//String url=request.getContextPath();
			response.setContentType("text/html;charset=utf-8"); 
			PrintWriter out = response.getWriter(); 
			StringBuilder alerts = new  StringBuilder("<script>alert('") 
					  .append(msg)
					  .append("');")
					  .append("location.href='")
					  .append(url)
					  .append("';")
					  .append("</script>"); 
			out.print(alerts.toString()); 
		//	out.flush();		//출력버퍼 비우기
			
			return false;
		} else if (request.getRequestURI().equals(url+"/member/list.do") && admin!=null) {
			return true;
		}
// 결론 : admin에 대한 인터셉터는 따로 만드는 것이 바람직하다.
//		ㄴ	 admin 접근 url은 /member로 시작하지 않고 /admin으로 별도 설계
//		ㄴ	admin
			
		if(member == null) {	//로그인 정보 있나?
			String msg="로그인 하세요.";
//			String url=request.getContextPath();
			response.setContentType("text/html;charset=utf-8");	//out 만들기 전에 해줘야 함
			PrintWriter out = response.getWriter(); 
			StringBuilder alerts = new  StringBuilder("<script>alert('") 
					  .append(msg)
					  .append("');")
					  .append("location.href='")
					  .append(url)
					  .append("';")
					  .append("</script>"); 
			out.print(alerts.toString()); 
			//out.flush();	//출력버퍼 비우기
			
			
			return false;		//요청에 정해진 handler 메소드로 제어(실행)가 이동되지 않습니다.
		}else {
		//로그인 된 상태이므로 요청에 따라 handler 메소드로 이동합니다.
			return true;
		}
	}
}
