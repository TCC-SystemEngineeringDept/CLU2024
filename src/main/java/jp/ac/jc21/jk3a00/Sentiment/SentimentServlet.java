package jp.ac.jc21.jk3a00.Sentiment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.jc21.jk3a00.api.KeyPhrases.GetKeyPhrases;

/**
 * Servlet implementation class LangDetectionFormServlet
 */
@WebServlet("/sentiment")
public class SentimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

		String parameter = request.getParameter("parameter");
		if(parameter == null) {
			parameter="";
		}
		request.setAttribute("parameter",parameter);
		

		Integer positive=30;
		request.setAttribute("positive",positive);
		Integer negative=1;
		request.setAttribute("negative",negative);
		Integer neutral=67;
		request.setAttribute("neutral",neutral);

		request.getRequestDispatcher("/jsp/sentiment.jsp").forward(request,response);
		}


}
