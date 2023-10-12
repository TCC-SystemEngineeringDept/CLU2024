package jp.ac.jc21.jk3a00.api.detection.request;
/* format
          {
              "id":"1",
              "text": "This is a document written in English."
          }
*/

public class LangReqAInputDocs {
	String id;
	String text;

	public LangReqAInputDocs() {
		this( "This is a document written in English.");
	}

	public LangReqAInputDocs(String parameter) {
		id="1";
		text = parameter;
	}
}
