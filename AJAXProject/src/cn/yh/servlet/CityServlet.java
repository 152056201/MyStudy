package cn.yh.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
import cn.yh.vo.City;




@SuppressWarnings("serial")
@WebServlet(urlPatterns="/CityServlet")
public class CityServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		int pid = Integer.parseInt(request.getParameter("pid"));
		try {
			List<City> all = ServiceFactory.getICityServiceInstance().findAll(pid);
			Iterator<City> ite = all.iterator();
			Document document = DocumentHelper.createDocument();
			Element allcityEle = document.addElement("allCits");
			while(ite.hasNext()) {
				City city = ite.next();
				Element citysElement = allcityEle.addElement("City");
				Element cidElement = citysElement.addElement("cid");
				Element cityElement = citysElement.addElement("city");
				cidElement.setText(String.valueOf(city.getCid()));
				cityElement.setText(city.getCity());
			}
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(response.getWriter(), format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	
}
