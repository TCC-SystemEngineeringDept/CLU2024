package jp.ac.jc21.jk3a00;

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

import jp.ac.jc21.jk3a00.api.WebApiConnector;
import jp.ac.jc21.jk3a00.api.request.LanguageDetectionRequestJson;
import jp.ac.jc21.jk3a00.api.response.LanguageDetectresponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// EndPoint URL
	private static final String apiUrl = "https://r05ai2.cognitiveservices.azure.com/";
	// EndPoint key
	private static final String subscriptionKey = "FeelTheNewDrive";
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// jsonパラメーターを作成
		LanguageDetectionRequestJson detectReq=new LanguageDetectionRequestJson();
		Gson gson=new Gson();
		String detectReqString = gson.toJson(detectReq);

		// jsonパラメーターを表示
		response.getWriter().append(detectReqString);
		
		// APIのURLを設定
		
		String url = apiUrl+
		"/language/:analyze-text?api-version=2022-05-01";

		// Subscription-Keyを設定
		HashMap< String , String >  map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", subscriptionKey);	
		
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
		
		if(detectResponse != null) {
			response.getWriter().append(detectResponse.results.documents[0].detectedLanguage.name);
			
		}

		
	}

}
