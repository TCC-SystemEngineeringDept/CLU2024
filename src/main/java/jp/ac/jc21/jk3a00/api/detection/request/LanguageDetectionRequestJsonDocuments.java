package jp.ac.jc21.jk3a00.api.detection.request;
/* format
          {
              "id":"1",
              "text": "This is a document written in English."
          }
*/

public class LanguageDetectionRequestJsonDocuments {
	String id;
	String text;

	public LanguageDetectionRequestJsonDocuments() {
		this( "This is a document written in English.");
	}

	public LanguageDetectionRequestJsonDocuments(String parameter) {
		id="1";
		text = parameter;
	}
}
