package chapter21;

import java.io.IOException;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/chapter21/el"})
public class EL extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		Product p=new Product();
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		request.setAttribute("product", p);
		
		Product p2=new Product();
		p2.setId(1);
		p2.setName("さば");
		p2.setPrice(2000);

		HttpSession session=request.getSession();
		session.setAttribute("product", p2);
		
		request.getRequestDispatcher("el.jsp")
			.forward(request, response);
	}
}
