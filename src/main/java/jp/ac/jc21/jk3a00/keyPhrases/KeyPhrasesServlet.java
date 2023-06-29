package jp.ac.jc21.jk3a00.keyPhrases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LangDetectionFormServlet
 */
@WebServlet("/keyPhrases")
public class KeyPhrasesServlet extends HttpServlet {
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

		String[] detected = {"実学の重視","人間性の涵養","社会への貢献"};
		request.setAttribute("detected",detected);


		request.getRequestDispatcher("/jsp/keyPhrases.jsp").forward(request,response);
		}


}
