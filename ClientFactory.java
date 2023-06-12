package SystemToBe;

public class ClientFactory {
    public static Client createClient(String type, String email, String password) {
        switch (type) {
            case "student":
                return new Student(email, password);
            case "faculty":
                return new Faculty(email, password);
            case "non-faculty":
                return new NonFaculty(email, password);
            case "visitor":
                return new Visitor(email, password);
            default:
                throw new IllegalArgumentException("Invalid client type: " + type);
        }
    }
}