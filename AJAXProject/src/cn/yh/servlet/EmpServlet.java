package cn.yh.servlet;

import java.io.IOException;

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


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/EmpServlet")
public class EmpServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("allEmps");
		for(int x= 1;x<=20;x++) {
			Element empElem = root.addElement("emp");
			Element empnoElem = empElem.addElement("empno");
			empnoElem.setText(String.valueOf(x));
			Element enameElem = empElem.addElement("ename");
			enameElem.setText("ÐÕÃû-"+x);
			Element jobElem = empnoElem.addElement("job");
			jobElem.setText("Ö°Î»-"+x);
		}
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(response.getWriter(), outputFormat);
		writer.write(document);
		writer.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
