package jp.ac.jc21.jk3a00.api.keyPhrases.request;

public class Analyzetextkeyphraseextractioninput {
	String kind;
	Multilanguageanalysisinput analysisInput;
	
	public Analyzetextkeyphraseextractioninput(String parameter) {
		setKind("KeyPhraseExtraction");
		setAnalysisInput(new Multilanguageanalysisinput(parameter));
	}
	public Analyzetextkeyphraseextractioninput() {
		this("Cause we all live in future world");
	}
	

}
