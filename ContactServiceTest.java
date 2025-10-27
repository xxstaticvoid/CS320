package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import mod3milestone.ContactService;


class ContactServiceTest {
	
	ContactService service;
	
	@BeforeEach
	void setup() {
		service = new ContactService();
	}
	
	
	@Test
	void testContactServiceClass1() {
		
		assertThrows(RuntimeException.class, () -> service.getContact("123"));
		assertThrows(RuntimeException.class, () -> service.getContact("1"));
		
		service.addContact("1", "Cooper", "DeJean", "0123456789", "123 Address St");
		
		assertEquals(service.getContact("1").getFirstName(), "Cooper");
		assertEquals(service.getContact("1").getLastName(), "DeJean");
		assertEquals(service.getContact("1").getPhone(), "0123456789");
		assertEquals(service.getContact("1").getAddress(), "123 Address St");
		
		service.updateFirstName("1", "Joseph");
		service.updateLastName("1", "Ebersole");
		service.updatePhone("1", "1112223334");
		service.updateAddress("1", "1300 Mustard Rd");
		
		assertEquals(service.getContact("1").getFirstName(), "Joseph");
		assertEquals(service.getContact("1").getLastName(), "Ebersole");
		assertEquals(service.getContact("1").getPhone(), "1112223334");
		assertEquals(service.getContact("1").getAddress(), "1300 Mustard Rd");
		
	}
	
	@Test
	void testContactServiceClass2() {

		assertDoesNotThrow(() -> service.addContact("2", "Cooper", "DeJean", "0123456789", "123 Address St" )); //valid
		assertThrows(NullPointerException.class, () -> service.addContact(null, "name", "tu", "1112223334" , "12 Addy Rd")); //one null add
		assertThrows(IllegalArgumentException.class, () -> service.addContact("4", null, "tu", "1112223334" , "12 Addy Rd")); //one null add
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null, null, null, null, null)); //full null add
		assertThrows(IllegalArgumentException.class, () -> service.addContact("69", "Jordan", "Davis", "123", "42 Wallaby Way"));
		assertThrows(IllegalArgumentException.class, () -> service.addContact("420", "Jordan", "Davis", "1287238979238743", "42 Wallaby Way"));
		assertThrows(IllegalArgumentException.class, () -> service.addContact("super long unique id huh", "Jordan", "Davis", "9999999999", "42 Wallaby Way"));
		
		assertThrows(RuntimeException.class, () -> service.updatePhone("1", "1287238979238743" ));
		assertThrows(RuntimeException.class, () -> service.updatePhone("1", "12" ));
	}
	
	@Test
	void testContactServiceClass3() {
		
		for(int i = 0; i < 25; i++) {
			service.addContact(Integer.toString(i), "Jordan", "Davis", "0123456789", "42 Wallaby Way");
		}
		
		service.addContact("26", "Devonta", "Smith", "5551231231", "69420 Sheesh Pkwy ");
		assertEquals(service.getContact("26").getAddress(), "69420 Sheesh Pkwy ");
		assertEquals(service.getContact("11").getPhone(), "0123456789");
		
		service.removeContact("11");
		assertThrows(RuntimeException.class, () -> service.getContact("11"));
		
	
	}

}
