package CarTracker.egen.io.service;

import java.util.Date;
import java.util.List;

import CarTracker.egen.io.entity.CarReadings;
import CarTracker.egen.io.entity.Readings;

public interface ReadingsService {

	//public List<Readings> findAll();

	public Readings create(Readings readings);

	public List<Readings> findByVin(String id);

	public List<CarReadings> findByPriority(String id);

	public List<Readings> findByRequired(String id, int time,String type);

	public List<Readings> findByTime(String id, String time, String time2);

}
