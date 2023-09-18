package tqs.coffeeCat.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "points")
public class PickupPoint {

	@Id
	private String id;
	private String name;
	private String address;
	private List<Order> orders;


    // Constructors
	public PickupPoint(String name, String address, List<Order> orders) {
		this.name = name;
		this.address = address;
		this.orders = orders;
	}

	public PickupPoint(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public PickupPoint() {
	}

    // Getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // toString
	@Override
	public String toString() {
		return "{" +
				" name='" + getName() + "'" +
				", address='" + getAddress() + "'" +
				", orders='" + getOrders() + "'" +
				"}";
	}

}
