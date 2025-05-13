package GroupProject;

public class Attendee extends User {
	Attendee(String id, String name) {
		super(id,name);
	}
	public void showProfile() {
		System.out.println("ID : "+id);
		System.out.println("Name : "+name);
	}
}
