package com.ssm.common.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ssm.common.util.DesUtils;

/**
 * 
 * ClassName: PasswordAnnotationResolver 
 * @Description: 自定义注解加密
 * @author zhangdaye
 * @date 2016-5-27
 */
public class PasswordAnnotationResolver implements HandlerMethodArgumentResolver {
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(Password.class) != null;
	}
	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest
				.getNativeRequest();
		Password passwordAnno = parameter.getParameterAnnotation(Password.class);
		String password = request.getParameter(passwordAnno.value());
		DesUtils desUtils = new DesUtils();
		return desUtils.encrypt(desUtils.encrypt(password));
	}



}