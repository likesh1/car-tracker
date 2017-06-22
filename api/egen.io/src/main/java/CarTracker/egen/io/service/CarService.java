package CarTracker.egen.io.service;

import java.util.List;

import CarTracker.egen.io.entity.Car;

public interface CarService {

	public List<Car> findAll();

	public List<Car> create(List<Car> car);
	
	public List<Car> findByVin(String id);

	
}
