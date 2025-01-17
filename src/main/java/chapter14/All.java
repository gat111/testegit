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

@WebServlet(urlPatterns={"/chapter14/all"})
public class All extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
			"select * from product");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getInt("price"));
				out.println("<br>");
			}

			//サーバリソースを適切に解放しできます。たとえば長いローカルメソッドの間に使用しなければ解放したほうがメモリは
			//効率的に使えます
			rs.close();		
			st.close();
			
//			//下記のように再度直ぐに使用するのであれば解放しないほうが良いです
//			 st=con.prepareStatement(
//					"select * from product");
//			 rs=st.executeQuery();
//			 
//				while (rs.next()) {
//					out.println(rs.getInt("id"));
//					out.println("：");
//					out.println(rs.getString("name"));
//					out.println("：");
//					out.println(rs.getInt("price"));
//					out.println("<br>");
//				}
//				
//			rs.close();		
//			st.close();
			
			
//			Connection オブジェクトをクローズすることで、コネクションプールのコネクションを解放することができます。具体的には、
//			コネクションプールを使用する場合、
//			Connection を閉じると実際にはコネクションが破棄されるわけではなく、プール内に返却され、再利用可能な状態に戻されます。
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
