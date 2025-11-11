package SystemToBe;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class MySystem {
	static ArrayList<Client> clients=new ArrayList<Client>();
	static ParkingSystem parkingSystem = new ParkingSystem();
	
    public static void registerUser(String type, String email, String password){
    	switch (type) {
        case "student":
            Student st = new Student(email, password);
            clients.add(st);
            break;
        case "faculty":
        	Faculty faculty = new Faculty(email, password);
            clients.add(faculty);
            break;
        case "nonfaculty":
        	NonFaculty nf = new NonFaculty(email, password);
            clients.add(nf);
            break;
        case "visitor":
        	Visitor v = new Visitor(email, password);
            clients.add(v);
            break;
        default:
            throw new IllegalArgumentException("Invalid client type: " + type);
    }
    }
    public static void registerClient(Client c) {
    	clients.add(c);
    }
}
