package CarTracker.egen.io.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CarTracker.egen.io.entity.Car;
import CarTracker.egen.io.entity.CarReadings;
import CarTracker.egen.io.entity.Readings;
import CarTracker.egen.io.entity.Tires;
import CarTracker.egen.io.repository.ReadingsRepository;
import CarTracker.egen.io.service.CarService;
import CarTracker.egen.io.service.ReadingsService;
import CarTracker.egen.io.service.TiresService;

@Service
public class ReadingsServiceImpl implements ReadingsService {

	private ReadingsRepository repository;
	private TiresService tiresservice;
	private CarService carservice;

	public ReadingsServiceImpl(TiresService tiresservice, ReadingsRepository repository, CarService carservice) {
		this.tiresservice = tiresservice;
		this.repository = repository;
		this.carservice = carservice;
	}

	@Override
	@Transactional
	public Readings create(Readings readings) {
		List<Car> car = carservice.findByVin(readings.getVin());
		int carRLR = car.get(0).getRedlineRpm();
		int maxFuel = car.get(0).getMaxFuelVolume();
		Tires tires = tiresservice.create(readings.getTires());
		readings.setTires(tires);
		return repository.create(readings, carRLR, maxFuel);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Readings> findByVin(String id) {

		return repository.findByVin(id);
	}

	@Override
	public List<CarReadings> findByPriority(String id) {
		return repository.findByPriority(id);
	}

	@Override
	public List<Readings> findByRequired(String id, int time,String type) {
		return repository.findByRequired(id,time,type);
	}

	@Override
	public List<Readings> findByTime(String id, String time, String time2) {
		System.out.println(time2);
		return repository.findByTime(id,time,time2);
	}

}
