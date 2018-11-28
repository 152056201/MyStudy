package cn.yh.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yh.dao.factory.ServiceFactory;
import cn.yh.vo.Dept;


@SuppressWarnings("serial")
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/page/error.jsp";
		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(uri!=null) {//表示有uri操作
			if("insert".equals(uri)) {//表示要执行insert操作
				path = this.insert(request);
			}else if("list".equals(uri)) {
				path = this.list(request);
			}else if("updatePre".equals(uri)){
				path = this.updatePre(request);
			}else if("update".equals(uri)) {
				path = this.update(request);
			}else if("delete".equals(uri)) {
				path = this.delete(request);
			}else if("listDetails".equals(uri)) {
				path = this.listDetails(request);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	public String insert(HttpServletRequest request) {
		Dept vo = new Dept();
		   vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		   vo.setDname(request.getParameter("dname"));
		   vo.setLoc(request.getParameter("loc"));
		   //调用服务层对数据进行保存，不管成还是失败，都应该为用户进行信息提示，现在要求其跳转回dept_insert.jsp页面
		   //以备下次的数据增加操作
		   String msg = "部门信息增加失败！";
		   try {
			if(ServiceFactory.getIDeptService().insert(vo)){
			   		msg="部门信息增加成功！";
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", "/page/back/admin/dept/dept_insert.jsp");
		return "/page/forward.jsp";
	}
	@SuppressWarnings("unchecked")
	public String delete(HttpServletRequest request) {
		String dno = request.getParameter("dno");
		   String msg = "部门信息删除失败！";
		   if(!(dno==null||"".equals(dno))){//确实dno有数据
			   String[] result = dno.split(" ");
		       Set<Integer> ids = new HashSet<Integer>();
		       for(int x= 0;x<result.length;x++){
		    	   ids.add(Integer.parseInt(result[x]));
		       }
		       Map<String, Object> map;
			try {
				map = ServiceFactory.getIDeptService().delete(ids);
			
		       boolean flag = (Boolean)map.get("flag");//成功或失败的标记
		       if(flag == true ){
		      		msg="部门信息删除成功！";
		      		Set<String> photoes = (Set<String>)map.get("allPhotos");
		      		Iterator<String> ite = photoes.iterator();
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
		      }
		       } catch (Exception e) {
					e.printStackTrace();
				}
		   }
		request.setAttribute("msg", msg);
		request.setAttribute("url", "/page/back/admin/dept/DeptServlet/list");   
		return "/page/forward.jsp";
	}
	public String list(HttpServletRequest request) {
		try {
			request.setAttribute("allDepts", ServiceFactory.getIDeptService().list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/dept/dept_list.jsp";
	
	}
	//更新前的查询
	public String updatePre(HttpServletRequest request) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
  		try {
			request.setAttribute("dept", ServiceFactory.getIDeptService().updatePre(deptno));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/dept/dept_update.jsp";
	
	}
	public String update(HttpServletRequest request) {
		 Dept vo = new Dept();
		   vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		   vo.setDname(request.getParameter("dname"));
		   vo.setLoc(request.getParameter("loc"));
		   //调用服务层对数据进行保存，不管成还是失败，都应该为用户进行信息提示，现在要求其跳转回dept_insert.jsp页面
		   //以备下次的数据增加操作
		   String msg = "部门信息新修改失败！";
		   try {
			if(ServiceFactory.getIDeptService().update(vo)){
			   		msg="部门信息修改成功！";
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
	    request.setAttribute("url", "/page/back/admin/dept/DeptServlet/list");
		return "/page/forward.jsp";
	
	}
	public String listDetails(HttpServletRequest request) {
		try {
			request.setAttribute("allDepts", ServiceFactory.getIDeptService().listDetails());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/back/admin/dept/dept_list_details.jsp";
	
	}

}
