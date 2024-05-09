package jp.ac.jc21.jk3a00.api.detection.request;

public class Docs {
	int id;
	String text;

	public void setId(int id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Docs(String t) {
		setId(1);
		setText(t);
	}
}
