package cn.yh.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yh.factory.ServiceFactory;
import cn.yh.util.MD5;
import cn.yh.vo.Member;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/MemberServlet/*")
public class MemberServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String uri = request.getRequestURI();
		String methodName = uri.substring(uri.lastIndexOf("/")+1);
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	//���ID
	public void checkMid(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		try {
		if(mid==null||"".equals(mid)) {
			response.getWriter().println(false);
		}else {
			response.getWriter().println(ServiceFactory.getIMembrServiceInstance().checkMid(mid));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	@SuppressWarnings("static-access")
	public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "/forward.jsp";
		String url = "/member_insert.jsp";
		String msg = null;
		if(this.validateCode(request)) {//�����֤���Ƿ���ȷ
			String mid = request.getParameter("mid");
			String password = request.getParameter("password");
			if(mid==null||"".equals(mid)) {
				msg = "�û�������Ϊ�գ�";
			}else {
				if(password==null||"".equals(password)) {
					msg="���벻��Ϊ�գ�";
				}else {
					password = new MD5().GetMD5Code(password);
					Member vo = new Member();
					vo.setMid(mid);
					vo.setPassword(password);
					if(ServiceFactory.getIMembrServiceInstance().insert(vo)) {
						msg="�û�ע��ɹ�";
					}else {
						msg= "�û�ע��ʧ�� ";
					}
				}
			}
		}else {
			msg="��֤���������������";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher(path).forward(request, response);
	}
	//��֤��
	public boolean validateCode(HttpServletRequest request) {
		String code = request.getParameter("code");
		String rand = (String)request.getSession().getAttribute("rand");
		if(code!=null) {
			if(code.equalsIgnoreCase(rand)) {
				return true;
			}
		}
		return false;
	}
	public void checkCode(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println(this.validateCode(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
