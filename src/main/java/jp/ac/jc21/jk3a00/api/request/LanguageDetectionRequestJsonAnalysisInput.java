package jp.ac.jc21.jk3a00.api.request;
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

}
