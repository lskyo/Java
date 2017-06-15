package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AsynServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AsynServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet start at:" + new Date());
		
//		AsyncContext context =  request.startAsync();
//		new Thread(new MyThread(context)).start();
		
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		new Thread(new MyThread()).start();
		
		System.out.println("Servlet end at:" + new Date());
	}
	
	public class MyThread implements Runnable{

		private AsyncContext context;
		
		
		public MyThread() {
		}
		
		public MyThread(AsyncContext context) {
			this.context = context;
		}
		
		
		
		@Override
		public void run() {
			HttpServletRequest req;
			HttpServletResponse resp;
			try {
				Thread.sleep(1000*5);
//				resp = (HttpServletResponse)context.getResponse();
//				req = (HttpServletRequest)context.getRequest();
//				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				System.out.println("MyThread end at :" + new Date());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
