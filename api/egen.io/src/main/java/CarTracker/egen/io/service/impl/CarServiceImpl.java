package CarTracker.egen.io.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import CarTracker.egen.io.entity.Car;
import CarTracker.egen.io.repository.CarRepository;
import CarTracker.egen.io.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository repository;
	List<Car> finalCar=new ArrayList<Car>();

	public CarServiceImpl(CarRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return repository.findAll();

	}

	@Override
	@Transactional
	public List<Car> create(List<Car> car) {

		for (int i = 0; i < car.size(); i++) {
			Optional<Car> mayExist = repository.findVin(car.get(i).getVin());
			if (mayExist.isPresent()) {
				finalCar.add(repository.update(car.get(i)));
			}else{
				finalCar.add(repository.create(car.get(i)));
			}
		}
		return finalCar;
	}

	@Override
	public List<Car> findByVin(String id) {
		return repository.findByVin(id);
	}

	


}
