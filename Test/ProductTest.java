import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testSetters() {
        // Test the setter methods
        Product product = new Product("P001", "Laptop", "High-performance laptop", 999.99);

        // Set new values using setters
        product.setID("P002");
        product.setName("Desktop");
        product.setDescription("Powerful desktop computer");
        product.setCost(799.99);

        // Check if setters modified the values
        assertEquals("P002", product.getID());
        assertEquals("Desktop", product.getName());
        assertEquals("Powerful desktop computer", product.getDescription());
        assertEquals(799.99, product.getCost(), 0.001);
    }
}
