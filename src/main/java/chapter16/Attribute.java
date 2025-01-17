package chapter16;

import java.io.IOException;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter16/attribute"})
public class Attribute extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		Product p=new Product();
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);
		
		request.setAttribute("product", p);
		
		request.removeAttribute("product");
		
		request.setAttribute("name", "清水");


		request.getRequestDispatcher("attribute.jsp")
			.forward(request, response);
	}
}
