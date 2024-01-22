import java.util.Calendar;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    // Constructors
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    // Additional overloaded constructors as needed

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    // Additional specified class methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        return calculateAge(Calendar.getInstance().get(Calendar.YEAR)) + " years";
    }

    public String getAge(int year) {
        return calculateAge(year) + " years";
    }

    public String toCSVDataRecord() {
        // Return CSV formatted string
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    // Private method to calculate age
    private int calculateAge(int currentYear) {
        return currentYear - YOB;
    }
}
