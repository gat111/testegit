package chapter22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter22/jstl"})
public class JSTL extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			ProductDAO dao=new ProductDAO();
			List<Product> list=dao.search("");

			request.setAttribute("list", list);

			
			Map<String, String> capitals = new HashMap<>();
			capitals.put("Japan", "Tokyo");
			capitals.put("USA", "Washington, D.C.");
			capitals.put("France", "Paris");
			request.setAttribute("capitals", capitals);
			
			request.setAttribute("userRole", "admin");
			
			
			request.getRequestDispatcher("jstl.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
