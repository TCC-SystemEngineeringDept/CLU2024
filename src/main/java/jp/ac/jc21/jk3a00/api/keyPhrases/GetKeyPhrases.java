package jp.ac.jc21.jk3a00.api.keyPhrases;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.ac.jc21.jk3a00.AzureApiDefinitionInterface;
import jp.ac.jc21.jk3a00.api.WebApiConnector;
import jp.ac.jc21.jk3a00.api.keyPhrases.request.Analyzetextkeyphraseextractioninput;
import jp.ac.jc21.jk3a00.api.keyPhrases.response.Keyphrasetaskresult;

public class GetKeyPhrases {

	public static String[] getKeyPhrases(String parameter) {
		// jsonパラメーターを作成
		Analyzetextkeyphraseextractioninput keyPhrasesRequest=new Analyzetextkeyphraseextractioninput(parameter);
//		Analyzetextkeyphraseextractioninput keyPhrasesRequest=new Analyzetextkeyphraseextractioninput();
		
		Gson gson=new Gson();
		String detectReqString = gson.toJson(keyPhrasesRequest);

		// jsonパラメーターを表示
		System.out.append(detectReqString);

		// APIのURLを設定

		String url = AzureApiDefinitionInterface.apiUrl+
		"/language/:analyze-text?api-version=2023-04-01";

		// Subscription-Keyを設定
		HashMap< String , String >  map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", AzureApiDefinitionInterface.subscriptionKey);

		// Proxy設定（学内利用のみ）
		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		Keyphrasetaskresult detectResponse=null;
		try {
			JsonReader reader;
			reader = WebApiConnector.postJsonReader(url, proxy, map, detectReqString);
			if (reader != null) {
				detectResponse = gson.fromJson(reader, Keyphrasetaskresult.class);
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
			if(detectResponse.getResults() != null) {
				keyPhrases=detectResponse.getResults().getDocuments()[0].getKeyPhrases();
			}
			if(detectResponse.getError()!= null) {
				System.err.println("ERROR:Code="+detectResponse.getError().getCode());
				System.err.println("ERROR:Message="+detectResponse.getError().getMessage());
			}
		}
		
		return keyPhrases;
	}

}