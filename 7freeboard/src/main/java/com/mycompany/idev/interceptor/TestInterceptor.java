package com.mycompany.idev.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//인터셉터 : 컨트롤러 동작 이전에 요청을 가로채기, 컨트롤러에서 응답을 보내기 이전에 가로채기
//			ㄴ servlet-context.xml에서 설정
public class TestInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(TestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("1.컨트롤러 handler method 매핑 이전에 실행.");	//전처리1	
		log.info("[Object handler 인자]-{}",handler);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("2.컨트롤러 handler method 실행 완료, view 생성하기 전에.");
		log.info("[Object handler 인자]-{}",handler);
		log.info("[ModelAndView 인자]-{}",modelAndView);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("3.view 생성까지 완료 후에");	//후처리
		log.info("[Object handler 인자]-{}",handler);
		log.info("[Exception 인자]-{}",ex);
	}
	
}
