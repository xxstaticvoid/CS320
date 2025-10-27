package mod3milestone;

/*
The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
*/


public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	
	public Contact(String uniqueId, String firstName, String lastName, String phone, String address) throws IllegalArgumentException{
		
		if (firstName == null || lastName == null || phone == null || address == null) {
			throw new IllegalArgumentException("Cant instantiate contact with null values");
		}
		
		
		if (uniqueId.length() > 10) {
			throw new IllegalArgumentException("Cant instantiate contact with ID that long");
		} else {
			this.contactId = uniqueId;
		}
		
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("Cant instantiate contact with firstname that long");
		} else {
			this.firstName = firstName;
		}
		
		
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Cant instantiate contact with lastname that long");
		} else {
			this.lastName = lastName;
		}
		
		if (address.length() > 30) {
			throw new IllegalArgumentException("Cant instantiate contact with address that long");
		} else {
			this.address = address;
		}
		
		
		if(phone.length() != 10) {
			throw new IllegalArgumentException("Phone must have length 10");
		} else {
			this.phone = phone;
		}
		
		
		
	}
	
	
	//Getters
	public String getContactId() { return this.contactId; }
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public String getPhone() { return this.phone; }
	public String getAddress() { return this.address; }
	
	
	
	
	
	//Setters
	public void setFirstName(String firstName) throws IllegalArgumentException {
		if (firstName == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if(firstName.length() > 10) {
			throw new IllegalArgumentException("Cant change value to name that long");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws IllegalArgumentException {
		if (lastName == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if(lastName.length() > 10) {
			throw new IllegalArgumentException("Cant change value to name that long");
		}
		
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) throws IllegalArgumentException {
		if (phone == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if(phone.length() != 10) {
			throw new IllegalArgumentException("Phone must have length 10");
		}
		
		this.phone = phone;
	}
	
	public void setAddress(String address) throws IllegalArgumentException {
		if (address == null) {
			throw new IllegalArgumentException("Cant change value to null");
		}
		
		if(address.length() > 30) {
			throw new IllegalArgumentException("Cant change value to address that long");
		}
		this.address = address;
	}
	
	
}
