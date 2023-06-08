package jp.ac.jc21.jk3a00.api.detection.request;
/* format
{
  {
      "documents":[
          {
              "id":"1",
              "text": "This is a document written in English."
          }

      ]
}
*/
public class LanguageDetectionRequestJsonAnalysisInput {
	LanguageDetectionRequestJsonDocuments[] documents;

	public LanguageDetectionRequestJsonAnalysisInput() {
		documents = new LanguageDetectionRequestJsonDocuments[1];
		documents[0] = new LanguageDetectionRequestJsonDocuments();
	}

	public LanguageDetectionRequestJsonAnalysisInput(String parameter) {
		documents = new LanguageDetectionRequestJsonDocuments[1];
		documents[0] = new LanguageDetectionRequestJsonDocuments(parameter);
	}

}
