package tqs.coffeeCat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tqs.coffeeCat.model.PickupPoint;

@Repository
public interface PickupPointRepository extends MongoRepository<PickupPoint, String> {
	PickupPoint findByName(String name);

	Boolean existsByName(String name);
}
