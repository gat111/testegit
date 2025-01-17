package chapter18;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		
		String name=URLEncoder.encode("名前", "utf-8");
		String value=URLEncoder.encode("値", "utf-8");
		Cookie cookie=new Cookie(name, value);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);

	}
}
