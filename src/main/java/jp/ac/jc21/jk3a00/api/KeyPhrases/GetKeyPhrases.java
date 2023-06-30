package jp.ac.jc21.jk3a00.api.KeyPhrases;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.ac.jc21.jk3a00.AzureApiDefinitionInterface;
import jp.ac.jc21.jk3a00.api.WebApiConnector;
import jp.ac.jc21.jk3a00.api.KeyPhrases.request.KeyPhrasesRequestJson;
import jp.ac.jc21.jk3a00.api.KeyPhrases.response.KeyPhrasesResponse;

public class GetKeyPhrases {

	public static String[] getKeyPhrases(String parameter) {
		// jsonパラメーターを作成
		KeyPhrasesRequestJson detectReq=new KeyPhrasesRequestJson(parameter);
//		KeyPhrasesRequestJson detectReq=new KeyPhrasesRequestJson();
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

		KeyPhrasesResponse detectResponse=null;
		try {
			JsonReader reader;
//			reader = WebApiConnector.postJsonReader(url, proxy, map, detectReqString);
			reader = WebApiConnector.postJsonReader(url, map, detectReqString);
			if (reader != null) {
				detectResponse = gson.fromJson(reader, KeyPhrasesResponse.class);
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

		String[] keyPhrases=new String[0];
		if(detectResponse != null) {
			if(detectResponse.results != null) {
				keyPhrases=detectResponse.results.documents[0].keyPhrases;
			}
		}
		return keyPhrases;
	}

}
