package com.exmaple.petstore;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetStoreServletTest {

	@Test
	public void testGetIntegerParameter_positiveInteger() {
		// setup 
		
		// Execute
		int output=PetStoreServlet.getIntegerParameter("4");
		
		// Assert
		assertEquals("expected parsed integer.", 4, output); 
	
	}
	
	@Test
	public void testGetIntegerParameter_negativeInteger() {
		// setup 
		
		// Execute
		int output=PetStoreServlet.getIntegerParameter("-4");
		
		// Assert
		assertEquals("expected parsed integer.", -4, output); 
	
	}
	
	@Test
	public void testGetIntegerParameter_decimalInteger() {
		// setup 
		
		// Execute
		int output=PetStoreServlet.getIntegerParameter("12.34");
		
		// Assert
		assertEquals("expected parsed integer.", -1, output); 
	
	}
	
	@Test
	public void testGetIntegerParameter_boolenInteger() {
		// setup 
		
		// Execute
		int output=PetStoreServlet.getIntegerParameter("12.34");
		
		// Assert
		assertEquals("expected parsed integer.", -1 , output); 
	
	}

}
