package chapter18;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;
@WebServlet(urlPatterns={"/chapter18/get"})
public class Get extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
		    for (Cookie cookie : cookies) {
		        String name=URLDecoder.decode(cookie.getName(), "utf-8");
		        String value=URLDecoder.decode(cookie.getValue(), "utf-8");
		        out.println("<p>"+name+" : "+value+"</p>");
		    }
		}

		

		Page.footer(out);
	}
}
