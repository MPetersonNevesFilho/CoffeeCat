package test.java.tqs.coffeeCat.model;

import tqs.coffeeCat.model.Order;
import tqs.coffeeCat.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.*;

public class OrderTests {

    @Test
    public void testOrderConstructorWithAllParameters() {
        Date dateCreated = new Date();
        Date dateDelivery = new Date();
        List<Product> products = new ArrayList<>();
        String status = "pending";
        String customer = "John Doe";
        String pickupPoint = "Store A";

        Order order = new Order(dateCreated, dateDelivery, products, status, customer, pickupPoint);

        assertNotNull(order);
        assertEquals(dateCreated, order.getDateCreated());
        assertEquals(dateDelivery, order.getDateDelivery());
        assertEquals(products, order.getProducts());
        assertEquals(status, order.getStatus());
        assertEquals(customer, order.getCustomer());
        assertEquals(pickupPoint, order.getPickupPoint());
    }

    @Test
    public void testOrderConstructorWithoutDateCreated() {
        Date dateDelivery = new Date();
        List<Product> products = new ArrayList<>();
        String customer = "Jane Doe";
        String pickupPoint = "Store B";

        Order order = new Order(dateDelivery, products, customer, pickupPoint);

        assertNotNull(order);
        assertEquals(dateDelivery, order.getDateDelivery());
        assertEquals(products, order.getProducts());
        assertEquals(customer, order.getCustomer());
        assertEquals(pickupPoint, order.getPickupPoint());
    }

    // Adicione mais testes conforme necessário

    @Test
    public void testToStringMethod() {
        Date dateCreated = new Date();
        Date dateDelivery = new Date();
        List<Product> products = new ArrayList<>();
        String status = "completed";
        String customer = "James Smith";
        String pickupPoint = "Store C";

        Order order = new Order(dateCreated, dateDelivery, products, status, customer, pickupPoint);

        String expectedToString = "{" +
                " dateCreated='" + dateCreated + "'" +	", dateDelivery='" + dateDelivery + "'" +
                ", products='" + products + "'" + ", status='" + status + "'" +
                ", costumer='" + customer + "'" + ", pickupPoint='" + pickupPoint + "'" +
                "}";

        assertEquals(expectedToString, order.toString());
    }
}
