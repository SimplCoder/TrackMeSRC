package com.trackme.spring;
 
import java.io.IOException;
import java.util.Set;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.UserMasterService;


public class CustomAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		HttpSession session = request.getSession();
		
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//try{
		StringBuilder queryStr=new StringBuilder();
		queryStr.append("select *  from usermaster where username like '"+authUser.getUsername()+"'");
		/* total = jdbcTemplate.execute(queryStr);
		UserMaster currentUser=UsermMasterDao.getUserMasterById(authUser.getUsername());
		session.setAttribute(Constant.CURRENT_USER, currentUser);  
       // session.setAttribute("authorities", authentication.getAuthorities()); 
        
        /*Set target URL to redirect
		String targetUrl = determineTargetUrl(authentication); */
        redirectStrategy.sendRedirect(request, response, "/home");
	}
 
	protected String determineTargetUrl(Authentication authentication) {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains("ROLE_ADMIN")) {
        	return "/admin.htm";
        } else if (authorities.contains("ROLE_USER")) {
        	return "/user.htm";
        } else {
            throw new IllegalStateException();
        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}