//package cn.fansunion.swagger.serverapi.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
///**
// * @author lm
// */
////测试用的
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		if (!(handler instanceof HandlerMethod)) {
//			return true;
//		}
//		// String str=charReader(request);
//		// System.out.println(str);
//		String token = request.getParameter("token");
//		System.out.println("request.getParameter(\"token\")=" + token);
//		return super.preHandle(request, response, handler);
//	}
//
//	String charReader(HttpServletRequest request) throws IOException {
//
//		BufferedReader br = request.getReader();
//
//		String str, wholeStr = "";
//		while ((str = br.readLine()) != null) {
//			wholeStr += str;
//		}
//		return wholeStr;
//
//	}
//}
