package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class serv1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get of"+Thread.currentThread());
	resp.setContentType("text/html");
	try(PrintWriter pw=resp.getWriter()){
		pw.print("<h1>welcome to java</h1><br>");
		
	}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy of"+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init of"+Thread.currentThread());
	}

}
