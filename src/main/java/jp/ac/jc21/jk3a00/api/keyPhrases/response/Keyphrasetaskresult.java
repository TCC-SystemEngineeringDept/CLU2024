package jp.ac.jc21.jk3a00.api.keyPhrases.response;

public class Keyphrasetaskresult {
	String kind; 
	Keyphraseresult  results;
	ErrorObject error;
	
	public String getKind() {
		return kind;
	}
	public Keyphraseresult getResults() {
		return results;
	}
	public ErrorObject getError() {
		return error;
	}
	

}
