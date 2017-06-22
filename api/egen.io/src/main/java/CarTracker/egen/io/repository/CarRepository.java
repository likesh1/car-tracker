package CarTracker.egen.io.repository;

import java.util.List;
import java.util.Optional;

import CarTracker.egen.io.entity.Car;

public interface CarRepository {

	public List<Car> findAll();

	public Optional<Car> findVin(String vin);

	public Car update(Car car);

	public Car create(Car car);

	public List<Car> findByVin(String id);

	

}
