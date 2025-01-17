package chapter14;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/update"})
public class Update extends HttpServlet {

    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        try {
        	
            System.out.println("実体クラス: " + request.getClass().getName());

            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(
                "java:/comp/env/jdbc/book");
            Connection con = ds.getConnection();

            
            // 更新するIDと新しい商品名をパラメータから取得
            int id = Integer.parseInt(request.getParameter("id"));
            String newName = request.getParameter("name");

    		con.setAutoCommit(false);
	        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);


            // SQL文を実行
            PreparedStatement st = con.prepareStatement(
                "UPDATE product SET name = ? WHERE id = ?");
            

			
            System.out.println("実体クラス: " + st.getClass().getName());

            st.setString(1, newName);
            st.setInt(2, id);
            int line = st.executeUpdate();

            if (line > 0) {
            	con.commit();
                out.println("更新に成功しました。");
            } else {
				con.rollback();
                out.println("更新対象が見つかりませんでした。");
            }
			con.setAutoCommit(true);

            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}

