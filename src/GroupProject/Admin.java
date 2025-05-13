package GroupProject;

import java.util.List;

import java.util.Iterator;
import java.util.List;

@RoleRequired(role = "Admin")
public class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }

    public void removeEvent(List<Event> events, String title) {
        Class<?> clazz = this.getClass();
        if (clazz.isAnnotationPresent(RoleRequired.class)) {
            Iterator<Event> it = events.iterator();
            while (it.hasNext()) {
                if (it.next().getTitle().equalsIgnoreCase(title)) {
                    it.remove();
                    System.out.println("Event \"" + title + "\" removed.");
                    return;
                }
            }
            System.out.println("Event not found.");
        } else {
            System.out.println("Permission Denied: Role not allowed.");
        }
    }
}

