package com.principal.bookjson;

import org.json.JSONObject;

public class BookSearch {

	BookService rbs;

	public BookSearch(BookService rbs) {
		this.rbs = rbs;
	}

	public Book getBook(int isbn) {
		String json = rbs.search(isbn);
		JSONObject obj = new JSONObject(json);
		String titulo = (String) obj.get("titulo");
		return new Book(titulo);
	}
}