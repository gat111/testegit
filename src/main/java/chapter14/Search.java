package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/search"})
public class Search extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
            Connection con = ds.getConnection();

            String keyword = request.getParameter("keyword");
            String priceRange = request.getParameter("priceRange");

            // SQL文の動的構築
            String sql = "SELECT * FROM product WHERE 1=1";
            if (keyword != null && !keyword.trim().isEmpty()) {
                sql += " AND name LIKE ?";
            }
            if (priceRange != null && !priceRange.isEmpty()) {
                sql += " AND price BETWEEN ? AND ?";
            }

            PreparedStatement st = con.prepareStatement(sql);
            int index = 1;

            if (keyword != null && !keyword.trim().isEmpty()) {
                st.setString(index++, "%" + keyword + "%");
            }

            if (priceRange != null && !priceRange.isEmpty()) {
                String[] range = priceRange.split("-");
                int minPrice = Integer.parseInt(range[0]);
                int maxPrice = Integer.parseInt(range[1]);
                st.setInt(index++, minPrice);
                st.setInt(index++, maxPrice);
            }

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                out.println(rs.getInt("id"));
                out.println("：");
                out.println(rs.getString("name"));
                out.println("：");
                out.println(rs.getInt("price"));
                out.println("<br>");
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}

