import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                ArrayList<Product> products = new ArrayList<>();

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                    // Display column headers
                    System.out.printf("%-8s%-15s%-30s%-10s\n", "ID#", "Name", "Description", "Cost");
                    System.out.println("==========================================================");

                    int line = 0;
                    while (reader.ready()) {
                        String rec = reader.readLine();
                        line++;

                        // Split the record into its components
                        String[] components = rec.split(", ");

                        // Create a Product object and add it to the list
                        Product product = new Product(components[0], components[1], components[2], Double.parseDouble(components[3]));
                        products.add(product);

                        // Display the data in a formatted columnar layout
                        System.out.printf("%-8s%-15s%-30s%-10s\n",
                                product.getID(), product.getName(), product.getDescription(), product.getCost());
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
