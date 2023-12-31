package tqs.coffeeCat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tqs.coffeeCat.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	Product findByName(String name);
	Boolean existsByName(String name);

	List<Product> findAll();
}
