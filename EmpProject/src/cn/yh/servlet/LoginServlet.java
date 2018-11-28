package cn.yh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yh.dao.factory.ServiceFactory;
import cn.yh.vo.Admin;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先定义一个公共表示错误路径的页面 error.jsp
		String path = "/page/error.jsp";
		String msg = null;
		String url = null;//表示forward提示信息后的跳转路径
		//servlet主要用于接受用户数据请求
		String code = request.getParameter("code");
		String rand = (String)request.getSession().getAttribute("rand");
		if(code!=null && rand !=null) {
			if(rand.equalsIgnoreCase(code)){
				Admin vo = new Admin();
				vo.setId(request.getParameter("username"));
				vo.setPassword(request.getParameter("password"));
				try {
					if(ServiceFactory.getIAdminService().Login(vo)){
						request.getSession().setAttribute("username",vo.getId());
						msg="验证成功！";
						url="/page/back/admin/main.jsp";
					}else{
						msg="登录失败，错误的验证名或密码！";
						url = "/page/back/admin/html/index.jsp";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				msg="验证码有误，请重新输入！";
				url="/page/back/admin/html/index.jsp";
			}
			path="/page/forward.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
