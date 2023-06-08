package jp.ac.jc21.jk3a00.api.detection.request;

/* format
{
  "parameters": {
      "modelVersion": "latest"
  }
}
*/
public class LanguageDetectionRequestJsonParameters {
	String modelVersion;

	public LanguageDetectionRequestJsonParameters() {
		modelVersion="latest";
	}
}
