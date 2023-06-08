package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value ="/test1",loadOnStartup = 2)
//web container reads this only once @ web app dep time
//wc  creates an empty map and then populate  url map
//key :/test1  value:pages.servelet1
public class servelet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get by :"+ Thread.currentThread());
		
		// set resp cont type (setting a resp hdr content-type: text/html
		resp.setContentType("text/html");
		
		//get pw to send char ,buff data (resp) to client
		try(PrintWriter pw=resp.getWriter()){
		pw.print("<h4> habibi come to satara:"+getClass()+"TS"+LocalDateTime.now()+"</h4>");	
		}//web container flush  buff contents are sent 
	}

	@Override
	public void destroy() {
		System.out.println("in destroy by :"+ Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init by :"+ Thread.currentThread());
	}

}
