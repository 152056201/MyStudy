package cn.vo.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yh.dao.factory.ServiceFactory;


@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/error.jsp";
		
		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(uri!=null) {
			if("main2".equals(uri)) {
				path = this.list(request);
			}
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	public String list(HttpServletRequest request) throws ServletException, IOException {
		String url = basePath.getBasePath(request)+"ListServlet/main2";
		try {
			request.setAttribute("allStudents", ServiceFactory.getIStudentService().list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "/main2.jsp";
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
