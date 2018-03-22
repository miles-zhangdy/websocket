package com.ssm.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.common.model.EnvironmentUserVO;
import com.ssm.util.Const;

public class ChatSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		EnvironmentUserVO userVO = (EnvironmentUserVO) session.getAttribute(Const.SESSION_ENVIR);
        String url = request.getRequestURI();
        if(userVO == null){  
	    	if(excludeURI(url)){  
	    		return true;  
	    	}else{  
    			response.setContentType("text/html");  
    			response.setCharacterEncoding("utf-8");  
    			PrintWriter out = response.getWriter();    
    			StringBuilder builder = new StringBuilder();    
    			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
    			builder.append("window.location.href=\""+request.getContextPath()+"/chat/tologin\";"); 
    			builder.append("</script>");    
    			out.print(builder.toString());    
    			out.close();    
    			return false;  
	    	}  
		}else{
	    	//可以对菜单路径进行动态控制
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	private boolean excludeURI(String url){
		if(url == null || url.equals("")){
			return false;
		}
		
		return url.contains("chat/login")
			|| url.contains("chat/logout")
			|| url.contains("chat/tologin");
	}
}
