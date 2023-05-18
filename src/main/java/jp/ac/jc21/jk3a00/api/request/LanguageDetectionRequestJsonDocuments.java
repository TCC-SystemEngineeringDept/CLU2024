package jp.ac.jc21.jk3a00.api.request;
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
		id="1";
		text = "This is a document written in English.";
	}
}
