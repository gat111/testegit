package chapter9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/forward"})
public class Forward extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		   // データをリクエストスコープに設定
	    request.setAttribute("message", "こんにちは、フォワード先へ2！");
		request.getRequestDispatcher("forward.jsp").forward(request, response);
	}
}


