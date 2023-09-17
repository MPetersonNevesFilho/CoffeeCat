package tqs.coffeeCat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tqs.coffeeCat.model.PickupPoint;
import tqs.coffeeCat.model.Order;
import tqs.coffeeCat.repository.PickupPointRepository;

@Service
public class PickupPointService {

	@Autowired
	private PickupPointRepository pickupPointRepository;

	public PickupPoint getPickupPoint(String name) {
		return pickupPointRepository.findByName(name);
	}

	public boolean existsByName(String name) {
		return pickupPointRepository.existsByName(name);
	}

	public List<PickupPoint> getAll() {
		return pickupPointRepository.findAll();
	}

	public PickupPoint addPickupPoint(PickupPoint pickupPoint) {
		if (pickupPointRepository.existsByName(pickupPoint.getName())) {
			return null;
		}
		return pickupPointRepository.save(pickupPoint);
	};

	public void deleteProduct(String id) {
		pickupPointRepository.deleteById(id);
	};

	public PickupPoint updatePickupPoint(PickupPoint pickupPoint) {
		return pickupPointRepository.save(pickupPoint);
	};

	public PickupPoint addOrderToPickupPoint(String pickupPointName, Order order) {
		PickupPoint pickupPoint = pickupPointRepository.findByName(pickupPointName);

		List<Order> orders = pickupPoint.getOrders();

		orders.add(order);

		pickupPoint.setOrders(orders);

		return pickupPointRepository.save(pickupPoint);
	}
}
