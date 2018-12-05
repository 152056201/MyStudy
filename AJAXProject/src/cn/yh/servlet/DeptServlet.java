package cn.yh.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.yh.factory.ServiceFactory;
import cn.yh.vo.Dept;





@SuppressWarnings("serial")
@WebServlet(urlPatterns="/DeptServlet/*")
public class DeptServlet extends HttpServlet {

	
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
	public void checkDeptno(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		response.getWriter().print(ServiceFactory.getIDeptServiceInstance().checkDeptno(deptno));
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		Dept vo = new Dept();
		vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		response.getWriter().print(ServiceFactory.getIDeptServiceInstance().insert(vo));
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		Dept vo = new Dept();
		vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		response.getWriter().print(ServiceFactory.getIDeptServiceInstance().update(vo));
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		String ids = request.getParameter("ids");
		String result[] = ids.split(" "); //通过空格进行拆分
		Set<Integer> set = new HashSet<>();
		for(int x= 0;x<result.length;x++) {
			set.add(Integer.parseInt(result[x]));
			
		}
		response.getWriter().print(ServiceFactory.getIDeptServiceInstance().delete(set));
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/xml");
		Iterator<Dept> ite = ServiceFactory.getIDeptServiceInstance().list().iterator();
		Document document = DocumentHelper.createDocument();
		Element allDpetsEle = document.addElement("allDepts");
		while(ite.hasNext()) {
			Dept dept = ite.next();
			Element deptEle = allDpetsEle.addElement("dept");
			Element deptnoEle = deptEle.addElement("deptno");
			Element dnameEle = deptEle.addElement("dname");
			Element locEle = deptEle.addElement("loc");
			deptnoEle.setText(String.valueOf(dept.getDeptno()));
			dnameEle.setText(dept.getDname());
			locEle.setText(dept.getLoc());
		}
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(response.getWriter(),outputFormat);
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
