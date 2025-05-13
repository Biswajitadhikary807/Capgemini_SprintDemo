package GroupProject;

public class Organizer extends User {
	boolean active=true;
	Organizer() {}
	boolean isActive() {
		return active;
	}
	void setActive(boolean b) {
		this.active=b;
	}
	public void showProfile() {
		System.out.println("Status : "+active);
	}
}
