package fa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.entity.MemberEntity;

@WebFilter(urlPatterns = {"/member/*"}, description = "Authentication filter ")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("Duyet ne");
		//get session
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
	    HttpSession session = request.getSession(false); // neu ko co session thi ko tao moi
	    
	    if (session == null ||  session.getAttribute("user") == null) {
	    	response.sendRedirect(request.getContextPath()+"/auth/login");
	    } else {
	    	System.out.println("co session ne");
	    	//lay ra user da luu, co the viet ham valid coi co thay doi thong tin gi hay ko
//	    	MemberEntity user = (MemberEntity) session.getAttribute("user");
	    	chain.doFilter(req, resp);
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Khoi tao Auth Filter");
		
	}

}

//https://stackoverflow.com/questions/47794773/how-to-register-a-servlet-filter-in-spring-mvc-application-without-initializer
