package tqs.coffeeCat.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private Date dateCreated;
	private Date dateDelivery;
	private List<Product> products;
	private String status;
	private String costumer;
	private String pickupPoint;


    // Constructors
	public Order(Date dateCreated, Date dateDelivery, List<Product> products, String status, String costumer, String pickupPoint) {
		this.dateCreated = dateCreated;
		this.dateDelivery = dateDelivery;
		this.products = products;
		this.status = status;
		this.costumer = costumer;
		this.pickupPoint = pickupPoint;
	}

	public Order(Date dateDelivery, List<Product> products, String costumer, String pickupPoint) {
		this.dateDelivery = dateDelivery;
		this.products = products;
		this.costumer = costumer;
		this.pickupPoint = pickupPoint;
	}

        // Debug
    public Order(String string, String string2, String string3, String name) {
	}

    public Order() {
    }

    // Getters
	public String getId() {
		return this.id;
	}

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public Date getDateDelivery() {
        return this.dateDelivery;
    }

	public List<Product> getProducts() {
		return this.products;
	}

	public String getStatus() {
		return this.status;
	}

    public String getCostumer() {
		return this.costumer;
	}

    public String getPickupPoint() {
		return this.pickupPoint;
	}

    // Setters
    public void setId(String id) {
		this.id = id;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCostumer(String costumer) {
		this.costumer = costumer;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

    // toString
	@Override
	public String toString() {
		return "{" +
				" dateCreated='" + getDateCreated() + "'" +	", dateDelivery='" + getDateDelivery() + "'" +
				", products='" + getProducts() + "'" + ", status='" + getStatus() + "'" +
				", costumer='" + getCostumer() + "'" + ", pickupPoint='" + getPickupPoint() + "'" +
				"}";
	}



}
