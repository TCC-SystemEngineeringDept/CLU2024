package jp.ac.jc21.jk3a00.CLU;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.jc21.jk3a00.api.language.GetLanguage;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

		String parameter = request.getParameter("textfield");
		if(parameter == null) {
			parameter="";
		}
		request.setAttribute("parameter",parameter);

		String detected = GetLanguage.getLanguageText(parameter);
		request.setAttribute("detected",detected);
		
		switch(detected) 
		{
			case "japanese":
				response.sendRedirect("./page1");
				break;
			case "english":
				response.sendRedirect("./page2");
				break;
			default:
				response.sendRedirect("./webIndex");
				break;
		}
	}

}
