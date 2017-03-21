package javamarathon5km.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javamarathon5km.dao.DBmanager;

/**
 * Servlet implementation class BaseballTeamServlet
 */
@WebServlet("/TeamDetail")
public class BaseballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBmanager dbm=new DBmanager();
		
		// 呼び出し元からデータ受け取り
		dbm.selectBaseballTeam(request.getParameter("id"));
		// ベースボールチームをセットする
		request.setAttribute("team",dbm.getBaseballTeam());
		//コンテキスト情報をセット
		ServletContext context = this.getServletContext();
		//呼び出し先を指定
		RequestDispatcher dispatcher = context.getRequestDispatcher("/Select_Team.jsp");
		//セットした値をフォワードする
		dispatcher.forward(request, response);


	}
}
