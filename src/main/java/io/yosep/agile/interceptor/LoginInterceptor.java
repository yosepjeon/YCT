package io.yosep.agile.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 작성일: 2019년 06월 15일
// 작성자: 전요셉
// 내용: 세션을 체크하여 지정한 URL경로에 대하여 로그인 체크를 하여 로그인이 되있으면 URL로 아니면 로그인 창으로 보내는 인터셉터 클래스
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// request로 부터 세션객체를 받아온다.
		HttpSession session = request.getSession();
		System.out.println("interceptor Doit");
		// 세션의 id가 null이면 => 로그인이 되어있지 않으면
		if(session.getAttribute("userId") == null) {
			System.out.println("user가 NULL입니다.");
			// 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/user/login");
			// 컨트롤러를 실행하지 않는다. => 요청페이지로 이동하지 않음
			return false;
		}else {
			System.out.println("문제없음.");
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
