package jp.ac.jc21.jk3a00.detection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.ac.jc21.jk3a00.AzureApiDefinitionInterface;
import jp.ac.jc21.jk3a00.api.WebApiConnector;
import jp.ac.jc21.jk3a00.api.detection.request.LanguageDetectionRequestJson;
import jp.ac.jc21.jk3a00.api.detection.response.LanguageDetectresponse;

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

		// jsonパラメーターを作成
		LanguageDetectionRequestJson detectReq=new LanguageDetectionRequestJson(parameter);
		Gson gson=new Gson();
		String detectReqString = gson.toJson(detectReq);

		// jsonパラメーターを表示
		System.out.append(detectReqString);

		// APIのURLを設定

		String url = AzureApiDefinitionInterface.apiUrl+
		"/language/:analyze-text?api-version=2022-05-01";

		// Subscription-Keyを設定
		HashMap< String , String >  map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", AzureApiDefinitionInterface.subscriptionKey);

		// Proxy設定（学内利用のみ）
		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		LanguageDetectresponse detectResponse=null;
		try {
			JsonReader reader;
			reader = WebApiConnector.postJsonReader(url, proxy, map, detectReqString);
			if (reader != null) {
				detectResponse = gson.fromJson(reader, LanguageDetectresponse.class);
				reader.close();
			}
		} catch (URISyntaxException e) {
			System.out.println("URISyntaxException");
			e.printStackTrace(System.out);
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace(System.out);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
			e.printStackTrace(System.out);
		}

		String detected="エラーが発生しているようです。resultsがnullでした";
		if(detectResponse != null) {
			if(detectResponse.results != null) {
			detected=detectResponse.results.documents[0].detectedLanguage.name;
			}
		}
		request.setAttribute("detected",detected);


		request.getRequestDispatcher("/jsp/langDetection.jsp").forward(request,response);
		}

}
