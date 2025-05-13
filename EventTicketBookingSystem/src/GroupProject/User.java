package GroupProject;

abstract public class User {
	protected String id;
	protected String name;
	User() {}
	User(String id,String name) {
		this.id=id;
		this.name=name;
	}
	abstract public void showProfile();
}
