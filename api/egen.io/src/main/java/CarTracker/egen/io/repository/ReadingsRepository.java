package CarTracker.egen.io.repository;

import java.util.Date;
import java.util.List;

import CarTracker.egen.io.entity.CarReadings;
import CarTracker.egen.io.entity.Readings;

public interface ReadingsRepository {

	public Readings create(Readings readings, int carRLR,int maxFuel);

	public List<Readings> findByVin(String id);

	public List<CarReadings> findByPriority(String id);

	public List<Readings> findByRequired(String id, int time,String type);

	public List<Readings> findByTime(String id, String time, String time2);

}
