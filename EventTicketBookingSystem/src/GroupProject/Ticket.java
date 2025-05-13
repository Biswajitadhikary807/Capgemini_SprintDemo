package GroupProject;

public class Ticket {
	Attendee attendee;
	Event event;
	String status;
	Ticket() {
		this.status="Booked";
	}
	void cancel() {
		this.status="Cancel";
	}
	public String getStatus() {
		return status;
	}
	public String ticketDetails() {
		return "Ticket for: \" + attendee.name + \" | Event: \" + event.getTitle() + \" | Status: \" + status";
	}
}
