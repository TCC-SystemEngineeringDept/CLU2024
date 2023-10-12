package jp.ac.jc21.jk3a00.api.detection.request;

public class LangReq {
	String kind;
	LangReqParams parameters;
	LangReqAInput analysisInput;

	public LangReq() {
		kind="LanguageDetection";
		parameters=new LangReqParams();
		analysisInput=new LangReqAInput();
	}
	public LangReq(String parameter) {
		kind="LanguageDetection";
		parameters=new LangReqParams();
		analysisInput=new LangReqAInput(parameter);
	}
}


