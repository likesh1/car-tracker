package CarTracker.egen.io.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import CarTracker.egen.io.entity.Car;
import CarTracker.egen.io.repository.CarRepository;


@Repository
public class CarRepositoryImpl implements CarRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Car> findAll() {
		TypedQuery<Car> query = em.createNamedQuery("Car.findAll", Car.class);
		return query.getResultList();
		
	}

	@Override
	public Optional<Car> findVin(String vin) {
		System.out.println("it is herr---------------------------------------");
		TypedQuery<Car> query = em.createNamedQuery("Car.findByVinID", Car.class);
		query.setParameter("pVin", vin);
		List<Car> users = query.getResultList();
		if (!users.isEmpty()) {
			System.out.println("it is herr---------------------------------------1");
			return Optional.of(users.get(0));
		} else {
			System.out.println("it is herr---------------------------------------2");
			return Optional.empty();
		}
	}

	@Override
	public Car update(Car car) {
		return em.merge(car);
	}

	@Override
	public Car create(Car car) {
		em.persist(car);
		return car;
	}

	@Override
	public List<Car> findByVin(String id) {
		TypedQuery<Car> query = em.createNamedQuery("Car.findByVinID", Car.class);
		query.setParameter("pVin", id);
		List<Car> car=query.getResultList();
		return car;
	}

		

}
