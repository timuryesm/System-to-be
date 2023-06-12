import SystemToBe.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTests {

    @Test
    public void testStudentRegistration() {
        String email = "student1test";
        assertEquals(false, Student.isEmailValid(email));

        email = "student1@test.com";
        assertEquals(true, Student.isEmailValid(email));

        String password = "stud123";
        assertEquals(false, Student.isPasswordValid(password));

        password = "Stud@123";
        assertEquals(false, Student.isPasswordValid(password));

        password = "Stud@123456";
        assertEquals(true, Student.isPasswordValid(password));

        MySystem.registerUser("student", email, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStudentRegistration() {
        String email = "student1@test.com";
        assertEquals(true, Student.isEmailValid(email));

        String password = "Stud@123456";
        assertEquals(true, Student.isPasswordValid(password));

        MySystem.registerUser("studentwrongtype", email, password);
    }

    @Test
    public void testFacultyRegistration() {
        String email = "faculty1test";
        assertEquals(false, Faculty.isEmailValid(email));

        email = "faculty1@test.com";
        assertEquals(true, Faculty.isEmailValid(email));

        String password = "faculty123";
        assertEquals(false, Faculty.isPasswordValid(password));

        password = "faculty@123";
        assertEquals(false, Faculty.isPasswordValid(password));

        password = "Faculty@123456";
        assertEquals(true, Faculty.isPasswordValid(password));

        MySystem.registerUser("faculty", email, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFacultyRegistration() {
        String email = "faculty1@test.com";
        assertEquals(true, Faculty.isEmailValid(email));

        String password = "Faculty@123456";
        assertEquals(true, Faculty.isPasswordValid(password));

        MySystem.registerUser("facultywrongtype", email, password);
    }

    @Test
    public void testNonFacultyRegistration() {
        String email = "nonfaculty1test";
        assertEquals(false, NonFaculty.isEmailValid(email));

        email = "nonfaculty1@test.com";
        assertEquals(true, NonFaculty.isEmailValid(email));

        String password = "nonfaculty123";
        assertEquals(false, NonFaculty.isPasswordValid(password));

        password = "nonfaculty@123";
        assertEquals(false, NonFaculty.isPasswordValid(password));

        password = "nonFaculty@123";
        assertEquals(true, NonFaculty.isPasswordValid(password));

        MySystem.registerUser("nonfaculty", email, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNonFacultyRegistration() {
        String email = "faculty1@test.com";
        assertEquals(true, NonFaculty.isEmailValid(email));

        String password = "Faculty@123456";
        assertEquals(true, NonFaculty.isPasswordValid(password));

        MySystem.registerUser("nonfacultywrongtype", email, password);
    }

    @Test
    public void testVisitorRegistration() {
        String email = "visitor1test";
        assertEquals(false, Visitor.isEmailValid(email));

        email = "visitor1@test.com";
        assertEquals(true, Visitor.isEmailValid(email));

        String password = "visitor123";
        assertEquals(false, Visitor.isPasswordValid(password));

        password = "visitor@123";
        assertEquals(false, Visitor.isPasswordValid(password));

        password = "Visitor@123";
        assertEquals(true, Visitor.isPasswordValid(password));

        MySystem.registerUser("visitor", email, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidVisitorRegistration() {
        String email = "visitor1@test.com";
        assertEquals(true, Visitor.isEmailValid(email));

        String password = "Visitor@123456";
        assertEquals(true, Visitor.isPasswordValid(password));

        MySystem.registerUser("visitorywrongtype", email, password);
    }
}
