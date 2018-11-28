package cn.yh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "lf", urlPatterns = { "/lf" })
public class LoginFilter implements Filter {

    public LoginFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//过滤器中取得HttpSession对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession ses = req.getSession();
		if(ses.getAttribute("username")!=null) {
			chain.doFilter(request, response);	
		}else {
			request.setAttribute("msg", "你还未登录，请先登录");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/forward.jsp").forward(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
