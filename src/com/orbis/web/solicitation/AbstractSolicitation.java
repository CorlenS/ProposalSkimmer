package com.orbis.web.solicitation;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class AbstractSolicitation implements Solicitation {
	private String url;
	private Document webDoc;
	private boolean docFetched = false;
	private Hashtable<String, String> fieldIds;
	private Hashtable<String, String> pageContent;

	protected abstract Hashtable<String, String> initializeFields();

	public AbstractSolicitation(String url) {
		this.url = url;
		fieldIds = initializeFields();
		pageContent = new Hashtable<String, String>();
	}

	public void fetchDoc() {
		try {
			webDoc = Jsoup.connect(url).get();
			docFetched = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetchPageContent() {
		if (!docFetched()) {
			fetchDoc();
		}

		for (Entry<String, String> e : fieldIds.entrySet()) {
			Elements element = webDoc.select(e.getValue());
			pageContent.put(e.getKey(), element.text());
		}
	}

	public boolean docFetched() {
		return docFetched;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> e : pageContent.entrySet()) {
			sb.append(e.getKey());
			sb.append(" : ");
			sb.append(e.getValue());
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
