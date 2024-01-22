import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                ArrayList<Person> folks = new ArrayList<>();

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                    // Display column headers
                    System.out.printf("%-8s%-15s%-15s%-8s%-8s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                    System.out.println("=================================================");


                    int line = 0;
                    while (reader.ready()) {
                        String rec = reader.readLine();
                        line++;

                        // Split the line into individual data elements
                        String[] data = rec.split(", ");

                        // Create a Person object and add it to the list
                        Person person = new Person(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                        folks.add(person);

                        // Display the data in a formatted columnar layout
                        System.out.printf("%-8s%-15s%-15s%-8s%-8s%n",
                                person.getID(), person.getFirstName(), person.getLastName(),
                                person.getTitle(), person.getYOB());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}