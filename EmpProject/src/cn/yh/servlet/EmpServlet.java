package cn.yh.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.yh.dao.factory.ServiceFactory;
import cn.yh.dao.util.basePath;
import cn.yh.vo.Dept;
import cn.yh.vo.Emp;


@SuppressWarnings("serial")
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/page/error.jsp";
		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(uri!=null) {//表示有uri操作
			if("insertPre".equals(uri)) {
				path = this.insertPre(request);
			}else if("insert".equals(uri)) {
				path = this.insert(request, response);
			}else if("list".equals(uri)) {
				path = this.list(request);
			}else if("listSplit".equals(uri)) {
				path = this.listSpilt(request);
			}else if("listDetail".equals(uri)) {
				path = this.listDetail(request);
			}else if("updatePre".equals(uri)) {
				path = this.updatePre(request);
			}else if("update".equals(uri)) {
				path = this.update(request, response);
			}else if("delete".equals(uri)) {
				path = this.delete(request);
			}else if("show".equals(uri)) {
				path = this.show(request);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	public String insertPre(HttpServletRequest request) throws ServletException, IOException{
		try {
			//尽量传递list集合，避免map集合传递到页面中
			Map<String,Object> map = ServiceFactory.getIEmpService().insertPer();
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("allDepts", map.get("allDepts"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/emp/emp_insert.jsp";
		
	}
	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SmartUpload smart = new SmartUpload();
		   smart.initialize(super.getServletConfig(), request,response);
		   try {
			smart.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		   //要接受请求参数，并设置到VO类对象中
		   Emp vo = new Emp();
		   vo.setEmpno(Integer.parseInt(smart.getRequest().getParameter("empno")));
		   vo.setEname(smart.getRequest().getParameter("ename"));
		   vo.setJob(smart.getRequest().getParameter("job"));
		   try {
			vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(smart.getRequest().getParameter("hiredate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		   vo.setSal(Double.parseDouble(smart.getRequest().getParameter("sal")));
		   vo.setComm(Double.parseDouble(smart.getRequest().getParameter("comm")));
		   int tempmgr = Integer.parseInt(smart.getRequest().getParameter("mgr"));
		   if(tempmgr != 0){
			   Emp mgr = new Emp();
			   mgr.setEmpno(tempmgr);
			   vo.setMgr(mgr);
		   }
		   int tempdeptno = Integer.parseInt(smart.getRequest().getParameter("dept")); 
		   if(tempdeptno != 0){
			   Dept dept = new Dept();
			   dept.setDeptno(tempdeptno);
			   vo.setDept(dept);
		   }
		   vo.setPhoto(smart.getRequest().getParameter("photo"));
		   vo.setNote(smart.getRequest().getParameter("note"));
		   //调用服务层对数据进行保存，不管成还是失败，都应该为用户进行信息提示，现在要求其跳转回dept_insert.jsp页面
		   //以备下次的数据增加操作
		   String fileName = "nophoto.jpg";
		   if(smart.getFiles().getFile(0).getSize()>0){
		   if(smart.getFiles().getFile(0).getContentType().contains("image")){
			   fileName = java.util.UUID.randomUUID()+"."+smart.getFiles().getFile(0).getFileExt();
			   }
		   }
		   vo.setPhoto(fileName);
		   vo.setNote(smart.getRequest().getParameter("note"));
		   String msg = "雇员信息增加失败！";
		   try {
			if(ServiceFactory.getIEmpService().insert(vo)){
				   if(smart.getFiles().getFile(0).getSize()>0){
					   if(smart.getFiles().getFile(0).getContentType().contains("image")){
						   String filePath = getServletContext().getRealPath("/upload/")+fileName;
						   smart.getFiles().getFile(0).saveAs(filePath);
					   }
				   }
			   		msg="雇员信息增加成功！";
			   }
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   request.setAttribute("msg", msg);
		   request.setAttribute("url", "/page/back/admin/emp/EmpServlet/insertPre");
		return "/page/forward.jsp";
		
	}
	
	public String list(HttpServletRequest request) throws ServletException, IOException{
		try {
			request.setAttribute("allEmps", ServiceFactory.getIEmpService().list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/emp/emp_list.jsp";
		
	}
	
	public String listSpilt(HttpServletRequest request) throws ServletException, IOException{
		String url = basePath.getBasePath(request)+"page/back/admin/emp/EmpServlet/listSplit";
		int currentpage = 1;
		int linesize = 5;
		String keyword="";//设置查询关键字
		int allRecorders = 0;//保存总记录数
		int pagesize = 0;//保存总页数
		String column = "ename";//设置默认查询列
		int lsDate[] = new int[]{1,5,10,15,20,25,30,35};//控制下拉列表显示数据量
		String columnDate = "编号:empno 姓名:ename 工作:job"; 
		
		try{
			//如果没有传入参数那么就会是null，null无法变为数字
			currentpage = Integer.parseInt(request.getParameter("cp"));
		}catch(Exception e){}
		try{
			linesize = Integer.parseInt(request.getParameter("ls"));
		}catch(Exception e){}
		if(request.getParameter("kw")!=null){
			//表示有查询关键字
			keyword = request.getParameter("kw");
		}
		if(request.getParameter("col")!=null){
			column = request.getParameter("col");
		}
		try {
			Map<String,Object> map = ServiceFactory.getIEmpService().list(currentpage, linesize, column, keyword);
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("allRecorders", map.get("empCount"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("columnDate", columnDate);
		request.setAttribute("keyword", keyword);
		request.setAttribute("column", column);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("linesize", linesize);
		request.setAttribute("url", url);
		
		return "/page/back/admin/emp/emp_list_split.jsp";
		
	}
	
	public String listDetail(HttpServletRequest request) throws ServletException, IOException{
		String url = basePath.getBasePath(request)+"page/back/admin/emp/EmpServlet/listDetail";
		int currentpage = 1;
		int linesize = 5;
		String keyword="";//设置查询关键字
		int allRecorders = 0;//保存总记录数
		int pagesize = 0;//保存总页数
		String column = "ename";//设置默认查询列
		int lsDate[] = new int[]{1,5,10,15,20,25,30,35};//控制下拉列表显示数据量
		String columnDate = "编号:empno 姓名:ename 工作:job"; 
		try{
			//如果没有传入参数那么就会是null，null无法变为数字
			currentpage = Integer.parseInt(request.getParameter("cp"));
		}catch(Exception e){}
		try{
			linesize = Integer.parseInt(request.getParameter("ls"));
		}catch(Exception e){}
		if(request.getParameter("kw")!=null){
			//表示有查询关键字
			keyword = request.getParameter("kw");
		}
		if(request.getParameter("col")!=null){
			column = request.getParameter("col");
		}
		
		try {
			Map<String,Object> map = ServiceFactory.getIEmpService().listDetails(currentpage, linesize, column, keyword);
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("allRecorders", map.get("empCount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("columnDate", columnDate);
		request.setAttribute("keyword", keyword);
		request.setAttribute("allRecorders", allRecorders);
		request.setAttribute("column", column);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("linesize", linesize);
		request.setAttribute("url", url);
		
		return "/page/back/admin/emp/emp_list_detail.jsp";
	}
	
	public String updatePre(HttpServletRequest request) throws ServletException, IOException{
		int empno = Integer.parseInt(request.getParameter("empno"));
  		try {
			Map<String,Object> map = ServiceFactory.getIEmpService().updatePre(empno);
			request.setAttribute("emp",map.get("emp"));
			request.setAttribute("allEmps",map.get("allEmps"));
			request.setAttribute("allDepts",map.get("allDepts"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/emp/emp_update.jsp";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 SmartUpload smart = new SmartUpload();
		   smart.initialize(super.getServletConfig(), request,response);
		   try {
			smart.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		   //要接受请求参数，并设置到VO类对象中
		   Emp vo = new Emp();
		   vo.setEmpno(Integer.parseInt(smart.getRequest().getParameter("empno")));
		   vo.setEname(smart.getRequest().getParameter("ename"));
		   vo.setJob(smart.getRequest().getParameter("job"));
		   try { 
			vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(smart.getRequest().getParameter("hiredate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		   vo.setSal(Double.parseDouble(smart.getRequest().getParameter("sal")));
		   vo.setComm(Double.parseDouble(smart.getRequest().getParameter("comm")));
		   int tempmgr = Integer.parseInt(smart.getRequest().getParameter("mgr"));
		   if(tempmgr != 0){
			   Emp mgr = new Emp();
			   mgr.setEmpno(tempmgr); 
			   vo.setMgr(mgr);
		   }
		   int tempdeptno = Integer.parseInt(smart.getRequest().getParameter("deptno")); 
		   if(tempdeptno != 0){
			   Dept dept = new Dept();
			   dept.setDeptno(tempdeptno);
			   vo.setDept(dept);
		   }
		  
		   vo.setNote(smart.getRequest().getParameter("note"));
		   //获取原始图片名称
		   String fileName = smart.getRequest().getParameter("oldpic");
		   if(smart.getFiles().getSize()>0){
			   if(smart.getFiles().getFile(0).getContentType().contains("image")){
				   if("nophoto.jpg".equals(fileName)){
					   fileName = java.util.UUID.randomUUID()+"."+smart.getFiles().getFile(0).getFileExt();
				   }
				   
			   }
		   }
		   vo.setPhoto(fileName);
		   //调用服务层对数据进行保存，不管成还是失败，都应该为用户进行信息提示，现在要求其跳转回dept_insert.jsp页面
		   //以备下次的数据增加操作
		   String msg = "雇员信息新修改失败！";
		   try {
			if(ServiceFactory.getIEmpService().update(vo)){
				   if(smart.getFiles().getFile(0).getContentType().contains("image")){
					   String filePath = getServletContext().getRealPath("/upload/")+fileName;
					   smart.getFiles().getFile(0).saveAs(filePath);
				   }
			   		msg="雇员信息修改成功！";
			   }
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   StringBuffer buf = new StringBuffer();
		   buf.append(smart.getRequest().getParameter("backurl")).append("?");
		   buf.append("cp=").append(smart.getRequest().getParameter("cp")).append("&");
		   buf.append("ls=").append(smart.getRequest().getParameter("ls")).append("&");
		   buf.append("col=").append(smart.getRequest().getParameter("col")).append("&");
		   buf.append("kw=").append(smart.getRequest().getParameter("kw"));
		   buf.append("deptno=").append(smart.getRequest().getParameter("backdeptno"));
		request.setAttribute("msg", msg);
		request.setAttribute("url", buf.toString());
		return "/page/forward.jsp";
		
	}
	
	public String delete(HttpServletRequest request) throws ServletException, IOException{
		 String eno = request.getParameter("eno");
		   String msg = "雇员信息删除失败！";
		   Set<String> photos = new HashSet<String>();//保存所有雇员的图片
		   if(!(eno==null||"".equals(eno))){//确实dno有数据
			   
			   String[] result = eno.split(" ");
		       Set<Integer> ids = new HashSet<Integer>();
		       for(int x= 0;x<result.length;x++){
		    	   String temp[] = result[x].split(":");
		    	   ids.add(Integer.parseInt(temp[0]));
		    	   if(!"nophoto.jpg".equals(temp[1])){
		    		   photos.add(temp[1]);
		    	   }
		       }
		       try {
				if(ServiceFactory.getIEmpService().delete(ids)){
					   Iterator<String> ite = photos.iterator();
				 		while(ite.hasNext()){
				 			String photo = ite.next();
				 			if(!"nophoto.jpg".equals(photo)){
				 				String filePath = getServletContext().getRealPath("/upload/")+photo;
				 				File file = new File(filePath);
				 				if(file.exists()){
				 					file.delete();
				 				}
				 			}
				 			
				 		}
				  		msg="雇员信息删除成功！";
				  }
			} catch (Exception e) {
				e.printStackTrace();
			}
		   }
		  
		   StringBuffer buf = new StringBuffer();
		   buf.append(request.getParameter("backurl")).append("?");
		   buf.append("cp=").append(request.getParameter("cp")).append("&");
		   buf.append("ls=").append(request.getParameter("ls")).append("&");
		   buf.append("col=").append(request.getParameter("col")).append("&");
		   buf.append("kw=").append(request.getParameter("kw"));
		   request.setAttribute("msg", msg);
		   request.setAttribute("url", buf.toString());
		return "/page/forward.jsp";
	}
	public String show(HttpServletRequest request) throws ServletException, IOException{
		int empno = Integer.parseInt(request.getParameter("empno"));
		try {
			request.setAttribute("emp", ServiceFactory.getIEmpService().show(empno));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/emp/emp_show.jsp";
	}
}
