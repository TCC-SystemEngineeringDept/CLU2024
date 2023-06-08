package jp.ac.jc21.jk3a00.detection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.jc21.jk3a00.api.detection.request.GetLanguage;

/**
 * Servlet implementation class LangDetectionFormServlet
 */
@WebServlet("/langDetect")
public class LangDetectionServlet extends HttpServlet {
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

		String detected = GetLanguage.getLanguageText(parameter);
		request.setAttribute("detected",detected);


		request.getRequestDispatcher("/jsp/langDetection.jsp").forward(request,response);
		}


}
