package cn.yh.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 反向阿贾克斯
 * @author Mr.Y
 *
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/ReverseServlet",asyncSupported=true)
public class ReverseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AsyncContext ac = request.startAsync();
		ac.start(new MessageThread(ac));//多线程启动进行服务器端推送
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	class MessageThread implements Runnable{
		private AsyncContext ac;
		public MessageThread(AsyncContext ac) {
			this.ac = ac;
		}
		@Override
		public void run() {
			String msg = this.ac.getRequest().getParameter("msg");
			try {
				this.ac.getResponse().getWriter().print("【服务器端回应信息】"+msg);
				this.ac.complete();//本次信息处理结束，将结果发送出去
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
