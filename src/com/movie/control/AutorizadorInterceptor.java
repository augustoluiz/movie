package com.movie.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object controller) throws Exception {
		
		String uri = request.getRequestURI();
        if(uri.endsWith("login") 
        		|| uri.endsWith("homeAdmin") 
        		|| uri.endsWith("/") 
        		|| uri.endsWith("homeAdmin")
        		|| uri.contains("filme")){
            return true;
        }
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }
		
		response.sendRedirect("login");
		return false;  
    }
	
}