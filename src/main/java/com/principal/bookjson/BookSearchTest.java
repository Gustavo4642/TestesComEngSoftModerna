package com.principal.bookjson;
import static org.junit.Assert.*;
import org.junit.*;

class BookConst {
   public static final String ESM = "{ \"titulo\": \"Eng Soft Moderna\" }";	
   public static final String NULLBOOK = "{ \"titulo\": \"NULL\" }";

}

class MockBookService implements BookService {
   public String search(int isbn) { 
	 if (isbn == 1234) 
  		return BookConst.ESM; 
	 return BookConst.NULLBOOK;
   }
}

public class BookSearchTest {
    
	BookService service1;
	
	@Before 
	public void init() {
	   service1 = new MockBookService();	
	}
	
	@Test
	public void testGetBook() {
		BookSearch bs = new BookSearch(service1);
		String titulo = bs.getBook(1234).getTitulo();
		assertEquals("Eng Soft Moderna", titulo);
	}
}
