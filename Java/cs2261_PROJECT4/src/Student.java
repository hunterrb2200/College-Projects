public class Student extends Person {
	public final String CLASS_STATUS;
	
	//method for Student
	public Student(String name, String address, String phone, String email, String classStatus) {
	super(name, address, phone, email);
	CLASS_STATUS = classStatus;
	}
}


