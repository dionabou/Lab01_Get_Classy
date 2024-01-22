import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;

public class PersonTest {

    @Test
    public void testConstructor() {
        // Test the constructor
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        assertEquals("Doe", person.getFirstName());
        assertEquals("Die", person.getLastName());
        assertEquals("123456", person.getID());
        assertEquals("Mr.", person.getTitle());
        assertEquals(1985, person.getYOB());
    }

    @Test
    public void testFullName() {
        // Test the fullName method
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        assertEquals("Doe Die", person.fullName());
    }

    @Test
    public void testFormalName() {
        // Test the formalName method
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        assertEquals("Mr. Doe Die", person.formalName());
    }

    @Test
    public void testGetAge() {
        // Test the getAge method
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String expectedAge = (currentYear - 1985) + " years";

        assertEquals(expectedAge, person.getAge());
    }

    @Test
    public void testGetAgeForSpecificYear() {
        // Test the getAge method for a specific year
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        int specificYear = 2000;
        String expectedAge = (specificYear - 1985) + " years";

        assertEquals(expectedAge, person.getAge(specificYear));
    }

    @Test
    public void testToCSVDataRecord() {
        // Test the toCSVDataRecord method
        Person person = new Person("123456", "Doe", "Die", "Mr.", 1985);

        assertEquals("123456, Doe, Die, Mr., 1985", person.toCSVDataRecord());
    }
}
