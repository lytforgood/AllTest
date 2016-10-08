package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.model.User;

/**
 * 登陆拦截器.拦截一部分需要登录的，其他全不用登录
 * 
 * 
 */
public class LoginInterceptor2 extends HandlerInterceptorAdapter {
	//需要拦截的界面
	private static final String[] IGNORE_URI = { "user/list.do"};

	//该方法将在请求处理之前进行调用
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean flag = true;
		String url = request.getRequestURL().toString();
		User user =(User) request.getSession().getAttribute("user");
//		System.out.println(">>>: 当前" + url);
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
//				System.out.println("已拦截");
				if (user == null) {
					response.sendRedirect(request.getContextPath()+"/view/login.jsp");
				}
				break;
			}
		}
		return flag;
	}

	//Controller 方法调用之后执行进行视图返回渲染之前被调用,这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
