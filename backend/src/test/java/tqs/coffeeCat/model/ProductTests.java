package test.java.tqs.coffeeCat.model;

import tqs.coffeeCat.model.PickupPoint;
import tqs.coffeeCat.model.Product;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {

    @Test
    public void testCreateProduct() {
        Product product = new Product("Coffee", "Delicious coffee beans", 10.0, "http://example.com/image.jpg");
        assertEquals("Coffee", product.getName());
        assertEquals("Delicious coffee beans", product.getDescription());
        assertEquals(10.0, product.getPrice());
        assertEquals("http://example.com/image.jpg", product.getImage_url());
    }

    @Test
    public void testToString() {
        Product product = new Product("Coffee", "Delicious coffee beans", 10.0, "http://example.com/image.jpg");
        String expectedString = "{" +
                " name='Coffee', description='Delicious coffee beans'" +
                ", price='10.0', image_url='http://example.com/image.jpg'" +
                "}";
        assertEquals(expectedString, product.toString());
    }

    // Adicione mais testes conforme necessário
}
