package jp.ac.jc21.jk3a00.api.language.request;

public class Docs {
	String id;
	String text;

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Docs(String s) {
		setId("1");
		setText(s);
	}

	public Docs() {
		this("Hello");
	}
}
/*
	{
		"id":"documentId",
		"text":"This document is in English."
	}
*/