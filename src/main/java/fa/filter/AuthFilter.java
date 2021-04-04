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

@WebFilter(urlPatterns = { "/member/*", "/content/*" }, description = "Authentication filter ")
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
//	    HttpSession session = request.getSession(false); // neu ko co session thi ko tao moi
	    HttpSession session = request.getSession(true); // neu ko co session thi  tao moi
	    System.out.println(request.getRequestURI());
	    String pathURI = request.getRequestURI().substring(request.getContextPath().length());
	    System.out.println(request.getContextPath());
	    System.out.println(pathURI);
	    if ( session.getAttribute("user") == null) {
	    	//luu duong dan cu
	    	session.setAttribute("preUrl",pathURI);
	    	//chuyen huong no qua login
	    	response.sendRedirect(request.getContextPath()+"/auth/login");
	    } else {
	    	System.out.println("co session ne");
//	    	String urlRedirect = (String) session.getAttribute("preUrl");
//	    	System.out.println("Co URL CU: "+urlRedirect);
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
