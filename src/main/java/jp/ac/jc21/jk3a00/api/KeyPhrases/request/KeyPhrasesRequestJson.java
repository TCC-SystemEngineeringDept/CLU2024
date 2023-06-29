package jp.ac.jc21.jk3a00.api.KeyPhrases.request;


public class KeyPhrasesRequestJson {
	String kind;
	KeyPhrasesRequestJsonParameters parameters;
	KeyPhrasesRequestJsonInput analysisInput;

	public KeyPhrasesRequestJson() {
		kind="KeyPhraseExtraction";
		parameters=new KeyPhrasesRequestJsonParameters();
		analysisInput=new KeyPhrasesRequestJsonInput();
	}
	public KeyPhrasesRequestJson(String parameter) {
		kind="KeyPhraseExtraction";
		parameters=new KeyPhrasesRequestJsonParameters();
		analysisInput=new KeyPhrasesRequestJsonInput(parameter);
	}
}


