package jp.ac.jc21.jk3a00.api.keyPhrases.request;

public class Multilanguageanalysisinput {

	Multilanguageinput[] documents;


	public Multilanguageanalysisinput(String parameter) {
		Multilanguageinput[] docs = new Multilanguageinput[1];
		docs[0]=new Multilanguageinput(parameter);
		setDocuments(docs);
	}
}
