import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter Product data (ID, Name, Description, Cost), or 'exit' to finish:");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Validate input using SafeInput (implement this logic based on your requirements)
                Product product = createProduct(input);
                products.add(product);
            }

            System.out.println("Enter a name for the file to save the Product data:");
            String fileName = scanner.nextLine().trim();

            // Save data to file
            saveToFile(fileName, products);

            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Product createProduct(String input) {
        // Implement logic to create a Product object from the input string
        // Split the input and create a new Product object with the values
        String[] components = input.split(", ");
        return new Product(components[0], components[1], components[2], Double.parseDouble(components[3]));
    }

    private static void saveToFile(String fileName, ArrayList<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
        }
    }
}
