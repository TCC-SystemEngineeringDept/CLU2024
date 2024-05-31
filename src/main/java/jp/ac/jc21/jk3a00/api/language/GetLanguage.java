package jp.ac.jc21.jk3a00.api.language;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.ac.jc21.jk3a00.AzureApiDefinitionInterface;
import jp.ac.jc21.jk3a00.api.WebApiConnector;
import jp.ac.jc21.jk3a00.api.language.request.LanguageParameter;
import jp.ac.jc21.jk3a00.api.language.response.LanguageResult;

public class GetLanguage {

	public static String getLanguageText(String parameter) {
		// jsonパラメーターを作成
		LanguageParameter detectReq=new LanguageParameter(parameter);
		Gson gson=new Gson();
		String detectReqString = gson.toJson(detectReq);

		// jsonパラメーターを表示
		System.out.append(detectReqString);
		System.out.append(System.lineSeparator());

		// APIのURLを設定

		String url = AzureApiDefinitionInterface.apiUrl+
		"/language/:analyze-text?api-version=2023-04-01";
		
		System.out.append(url);
		System.out.append(System.lineSeparator());

		// Subscription-Keyを設定
		HashMap< String , String >  map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", AzureApiDefinitionInterface.subscriptionKey);

		// Proxy設定（学内利用のみ）
		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		LanguageResult response=null;
		try {
			JsonReader reader;
			reader = WebApiConnector.postJsonReader(url, proxy, map, detectReqString);
//			reader = WebApiConnector.postJsonReader(url, map, detectReqString);
			if (reader != null) {
				response = gson.fromJson(reader, LanguageResult.class);
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
		if(response != null) {
			detected = response.getResults().getDocuments()[0].getDetectedLanguage().getName();
			System.out.append(detected);
			System.out.append(System.lineSeparator());
		}

		
		return detected;
	}

}
