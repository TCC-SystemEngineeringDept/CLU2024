package jp.ac.jc21.jk3a00.api.detection.request;

public class AInput {
	Docs[] documents;

	public Docs[] getDocuments() {
		return documents;
	}

	public void setDocuments(Docs[] documents) {
		this.documents = documents;
	}

	public AInput(String t) {
		Docs[] d = new Docs[1];
		d[0] = new Docs(t);
		setDocuments(d);

	}
}
