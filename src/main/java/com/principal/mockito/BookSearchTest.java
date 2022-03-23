package com.principal.mockito;

import static org.junit.Assert.*; 
import org.junit.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

class BookConst {
	public static final String ESM = "{ \"titulo\": \"Eng Soft Moderna\" }";
	public static final String NULLBOOK = "NULL";
}

public class BookSearchTest {

	BookService service;

	@Before
	public void init() {
		service = Mockito.mock(BookService.class);
		when(service.search(anyInt())).thenReturn(BookConst.NULLBOOK);
		when(service.search(1234)).thenReturn(BookConst.ESM);
	}

	@Test
	public void testGetBook() {
		BookSearch bs = new BookSearch(service);
		String titulo = bs.getBook(1234).getTitulo();
		assertEquals("Eng Soft Moderna", titulo);
	}
}