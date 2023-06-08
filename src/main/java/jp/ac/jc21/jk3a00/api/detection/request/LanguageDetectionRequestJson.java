package jp.ac.jc21.jk3a00.api.detection.request;

/* format
{
  "kind": "LanguageDetection",
  "parameters": {
      "modelVersion": "latest"
  },
  "analysisInput":{
      "documents":[
          {
              "id":"1",
              "text": "This is a document written in English."
          }
      ]
  }
}
*/


public class LanguageDetectionRequestJson {
	String kind;
	LanguageDetectionRequestJsonParameters parameters;
	LanguageDetectionRequestJsonAnalysisInput analysisInput;

	public LanguageDetectionRequestJson() {
		kind="LanguageDetection";
		parameters=new LanguageDetectionRequestJsonParameters();
		analysisInput=new LanguageDetectionRequestJsonAnalysisInput();
	}
	public LanguageDetectionRequestJson(String parameter) {
		kind="LanguageDetection";
		parameters=new LanguageDetectionRequestJsonParameters();
		analysisInput=new LanguageDetectionRequestJsonAnalysisInput(parameter);
	}
}


