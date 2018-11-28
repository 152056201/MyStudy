package cn.yh.util.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "ef", urlPatterns = { "/ef" })
public class EncodingFilter implements Filter {
	private String charset = "UTF-8"; // 设置默认编码
    
    public EncodingFilter() {
        
    }

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charset);
		response.setCharacterEncoding(this.charset);
		chain.doFilter(request, response);//放行
	}

	public void init(FilterConfig Config) throws ServletException {
		if(Config.getInitParameter("charset")!=null) {
			this.charset = Config.getInitParameter("charset");
		}
	}

}
