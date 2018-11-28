package cn.vo.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yh.dao.factory.ServiceFactory;
import cn.yh.vo.Admin;


@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/error.jsp";
		String msg = null;
		String url = null;
		String username = request.getParameter("username");
		String passwor = request.getParameter("password");
		
		if(username!=null && passwor!=null) {
			Admin vo = new Admin();
			vo.setId(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			
				try {
					if(ServiceFactory.getIAdminService().Login(vo)) {
						request.getSession().setAttribute("username", vo.getId());
						msg = "登录成功，欢迎登录";
						url = "/main2.jsp";
					}else {
						msg="登录失败，错误的用户名或密码";
						url="/index.jsp";
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			path="/forward.jsp";
		}
			
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
