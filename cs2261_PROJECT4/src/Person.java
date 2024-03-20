public class Person extends Main {
	//adds objects
	public String address;
	public String phone;
	public String email;
	public String name;

	//Person method
	public Person(String name, String address, String phone, String email) {
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.email = email;
	}
	
	//main override for the program to get toStrings working
	@Override
	public String toString() {
	return this.getClass().getName() + "\n" + name;
	}
}	
