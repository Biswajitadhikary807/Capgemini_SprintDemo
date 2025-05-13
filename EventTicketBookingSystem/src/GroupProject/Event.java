package GroupProject;

public class Event {
	String title;
	int availableTickets;
	public boolean isAvailable() {
		return (availableTickets>0);
	}
	public void setAvailableTickets(int tickets) {
		this.availableTickets=tickets;
	}
}
