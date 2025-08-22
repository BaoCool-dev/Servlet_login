package controller_cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// Lay du lieu tu tham so cua form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if(user.equals("chibao")&&pass.equals("123"))
		{
			Cookie cookie = new Cookie("username",user) ;
			//thiet lap thoi gian ton tai
			cookie.setMaxAge(30);
			//them cookie vao response
			resp.addCookie(cookie);
			//chuyen sang trang HelloServlet
			resp.sendRedirect("/HelloServlet/hello");
		}else {
			//chuyensang trang LoginServlet
			resp.sendRedirect("/HelloServlet/login");
		}
		
	}
	
}
