package jp.ac.jc21.jk3a00.api.language.request;
/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */
public class LanguageParameter {

	String kind;
	AInput analysisInput;

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setAnalysisInput(AInput analysisInput) {
		this.analysisInput = analysisInput;
	}

	public LanguageParameter(String text) {
		setKind("LanguageDetection");
		setAnalysisInput(new AInput(text));
	}

}