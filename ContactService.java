package mod3milestone;

import java.util.*;


/*
 * 
    The contact service shall be able to add contacts with a unique ID.
    The contact service shall be able to delete contacts per contact ID.
    The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
        firstName
        lastName
        Number
        Address

 * 
 */

public class ContactService {
	
	private Map<String, Contact> contactList = new HashMap<>();
	
	
	public ContactService() {
		
	}
	
	
	
	public void addContact(String uniqueId, String firstName, String lastName, String phone, String address) throws IllegalArgumentException {
		var temp = new Contact(uniqueId, firstName, lastName, phone, address);
		contactList.putIfAbsent(uniqueId, temp);	//add to hash map
	}
	
	public void removeContact(String uniqueId) throws RuntimeException {
		if(contactList.containsKey(uniqueId)) {
			contactList.remove(uniqueId);
			return;
		}
		throw new RuntimeException("Value not found");
	}
	
	
	//Getters
	public Contact getContact(String contactId) {
		if(contactList.containsKey(contactId)) {
			return contactList.get(contactId);
		}
		throw new RuntimeException("Value not found");
	}
	
	
	
	//Setters
	public void updateFirstName(String contactId, String firstName) throws RuntimeException, IllegalArgumentException {
		this.getContact(contactId).setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		this.getContact(contactId).setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		this.getContact(contactId).setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		this.getContact(contactId).setAddress(address);
	}

	
	
	
	
}
