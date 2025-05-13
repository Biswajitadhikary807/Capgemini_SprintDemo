package GroupProject;

import java.io.*;
import java.util.*;

public class EventBookingSystem {
    List<Attendee> attendees = new ArrayList<>();
    List<Organizer> organizers = new ArrayList<>();
    List<Event> events = new ArrayList<>();
    List<Ticket> tickets = new ArrayList<>();

    public void registerUser(User user) {
        if (user instanceof Attendee) {
            attendees.add((Attendee) user);
        } else if (user instanceof Organizer) {
            organizers.add((Organizer) user);
        }
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void bookTicket(String attendeeId, String eventTitle) throws InvalidBookingException {
        Attendee attendee = null;
        for (Attendee a : attendees) {
            if (a.id.equals(attendeeId)) {
                attendee = a;
                break;
            }
        }
        if (attendee == null) throw new InvalidBookingException("Attendee not registered.");

        for (Event e : events) {
            if (e.getTitle().equalsIgnoreCase(eventTitle)) {
                if (e.isAvailable()) {
                    Ticket ticket = new Ticket(attendee, e);
                    tickets.add(ticket);
                    e.setAvailableTickets(e.getAvailableTickets() - 1);
                    System.out.println("Ticket booked!");
                    return;
                } else {
                    throw new InvalidBookingException("No tickets available.");
                }
            }
        }
        throw new InvalidBookingException("Event not found.");
    }

    public void showEvents() {
        for (Event e : events) {
            System.out.println(e);
        }
    }

    public void saveEvents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.ser"))) {
            oos.writeObject(events);
            System.out.println("Events saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadEvents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.ser"))) {
            events = (List<Event>) ois.readObject();
            System.out.println("Events loaded.");
        } catch (Exception e) {
            System.out.println("No previous events found.");
        }
    }
}

