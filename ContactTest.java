package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import mod3milestone.Contact;

class ContactTest {


	@Test
	void testContactClass1() {
		
		//Contact 1
		var testContact = new Contact("1", "Jalen", "Hurts", "0123456789", "123 Address St");
		
		assertEquals(testContact.getContactId(), "1");
		assertEquals(testContact.getFirstName(), "Jalen");
		assertEquals(testContact.getLastName(), "Hurts");
		assertEquals(testContact.getPhone(), "0123456789");
		assertEquals(testContact.getAddress(), "123 Address St");
		
		assertTrue(testContact.getContactId().length() <= 10);
		assertTrue(testContact.getFirstName().length() <= 10);
		assertTrue(testContact.getLastName().length() <= 10);
		assertTrue(testContact.getPhone().length() == 10);
		assertTrue(testContact.getAddress().length() <= 30);
		
	}
	
	@Test
	void testContactClass2() {
		
		//Contact 2
		var testContact = new Contact("69", "Cooper", "DeJean", "0123456789", "123 Address St");
		testContact.setFirstName("FirstName");
		testContact.setLastName("LastName");
		testContact.setPhone("9999999991");
		testContact.setAddress("42 Wallaby Way");
		assertEquals(testContact.getFirstName(), "FirstName");
		assertEquals(testContact.getLastName(), "LastName");
		assertEquals(testContact.getPhone(), "9999999991");
		assertEquals(testContact.getAddress(), "42 Wallaby Way"); 
			
	}
	
	
	
	@Test
	void testContactClass3() {
		
		//test instantiation
		assertDoesNotThrow(() -> new Contact("123", "Cooper", "DeJean", "0123456789", "123 Address St"));
		
		assertThrows(IllegalArgumentException.class, () -> new Contact("67", "Saquon", "Barkley", "000123456", "555 Jupiter Pluto Ln"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("super long unique id", "Saquon", "Barkley", "1231231239", "1567 Bikini Bottom"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("420", "Saquon", "Barkley", "00012345678999", "1567 Bikini Bottom"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("420", "Saquon", "Barkley", "0123456789", new String(new char[31])));
		
		
		assertThrows(IllegalArgumentException.class, () -> new Contact("101", "Jalen", "Hurts", null, "1567 Bikini Bottom"));
		assertThrows(NullPointerException.class, () -> new Contact(null, "Jalen", "Hurts", "1234567890", "1567 Bikini Bottom"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("404", null, null, null, null));
		
		
		var testContact = new Contact("69", "AJ", "Brown", "0123456789", "123 Address St");
		assertThrows(IllegalArgumentException.class, () -> testContact.setPhone("99999999999999999"));
		assertThrows(IllegalArgumentException.class, () -> testContact.setPhone("999"));
	}
	
	
	@Test
	void testContactClass4() {
		
		var testContact = new Contact("69", "AJ", "Brown", "0123456789", "123 Address St");
		assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(null));
		assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(new String(new char[11])));
		
		assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(null));
		assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(new String(new char[11])));
		
		assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(null));
		
		assertThrows(IllegalArgumentException.class, () -> testContact.setAddress(null));
		assertThrows(IllegalArgumentException.class, () -> testContact.setAddress(new String(new char[31])));

		
	}

}
	
	
	
