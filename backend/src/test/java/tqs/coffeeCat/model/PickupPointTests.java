package test.java.tqs.coffeeCat.model;

import tqs.coffeeCat.model.PickupPoint;
import tqs.coffeeCat.model.Order;
import tqs.coffeeCat.model.Product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PickupPointTests {

    @Test
    public void testCreatePickupPointWithOrders() {
        List<Product> products = new ArrayList<>();
        Product product = new Product("Coffee", "Delicious coffee beans", 10.0, "http://example.com/image.jpg");
        products.add(product);

        List<Order> orders = new ArrayList<>();
        Order order = new Order(new Date(), null, products, "Pending", "John Doe", "Point A");
        orders.add(order);

        PickupPoint pickupPoint = new PickupPoint("Point A", "Address A", orders);

        assertEquals("Point A", pickupPoint.getName());
        assertEquals("Address A", pickupPoint.getAddress());
        assertEquals(orders, pickupPoint.getOrders());
    }

    @Test
    public void testCreatePickupPointWithoutOrders() {
        PickupPoint pickupPoint = new PickupPoint("Point B", "Address B");

        assertEquals("Point B", pickupPoint.getName());
        assertEquals("Address B", pickupPoint.getAddress());
        assertNull(pickupPoint.getOrders());
    }

    @Test
    public void testToString() {
        PickupPoint pickupPoint = new PickupPoint("Point A", "Address A");
        String expectedString = "{" +
                " name='Point A', address='Address A', orders='null'" +
                "}";
        assertEquals(expectedString, pickupPoint.toString());
    }

    // Adicione mais testes conforme necessário
}