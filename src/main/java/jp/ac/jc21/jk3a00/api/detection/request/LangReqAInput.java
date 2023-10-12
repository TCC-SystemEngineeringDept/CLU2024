package jp.ac.jc21.jk3a00.api.detection.request;

public class LangReqAInput {
	LangReqAInputDocs[] documents;

	public LangReqAInput() {
		documents = new LangReqAInputDocs[1];
		documents[0] = new LangReqAInputDocs();
	}

	public LangReqAInput(String parameter) {
		documents = new LangReqAInputDocs[1];
		documents[0] = new LangReqAInputDocs(parameter);
	}

}
