package GroupProject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventBookingSystem system = new EventBookingSystem();
        system.loadEvents();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register Attendee");
            System.out.println("2. Add Event");
            System.out.println("3. Book Ticket");
            System.out.println("4. Show Events");
            System.out.println("5. Save & Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        system.registerUser(new Attendee(id, name));
                        break;

                    case 2:
                        System.out.print("Enter Event Title: ");
                        String title = sc.nextLine();
                        System.out.print("Available Tickets: ");
                        int tickets = sc.nextInt();
                        sc.nextLine();
                        system.addEvent(new Event(title, tickets));
                        break;

                    case 3:
                        System.out.print("Enter Attendee ID: ");
                        String attendeeId = sc.nextLine();
                        System.out.print("Enter Event Title: ");
                        String eventTitle = sc.nextLine();
                        system.bookTicket(attendeeId, eventTitle);
                        break;

                    case 4:
                        system.showEvents();
                        break;

                    case 5:
                        system.saveEvents();
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}



