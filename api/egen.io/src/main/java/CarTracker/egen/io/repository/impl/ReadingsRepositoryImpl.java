package CarTracker.egen.io.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import CarTracker.egen.io.entity.CarReadings;
import CarTracker.egen.io.entity.Readings;
import CarTracker.egen.io.repository.ReadingsRepository;

@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Readings create(Readings readings, int carRLR, int maxFuel) {
		if (readings.getEngineRpm() > carRLR) {
			readings.setHighPrioirty(true);
		}
		if (readings.getFuelVolume() < (0.1 * maxFuel)) {
			readings.setMidPrioirty(true);
		}
		if (readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontRight() < 32
				|| readings.getTires().getRearLeft() < 32 || readings.getTires().getRearRight() < 32
				|| readings.getTires().getRearLeft() > 36 || readings.getTires().getRearRight() > 36
				|| readings.getTires().getFrontRight() > 36 || readings.getTires().getFrontLeft() > 36) {
			readings.setLowPrioirty(true);
		}
		if (readings.isEngineCoolantLow() == true || readings.isCheckEngineLightOn() == true) {
			readings.setEnginePrioirty(true);
		}
		em.persist(readings);
		return readings;
	}

	@Override
	public List<Readings> findByVin(String id) {
		TypedQuery<Readings> query = em.createNamedQuery("Readings.findByVin", Readings.class);
		query.setParameter("pVin", id);
		List<Readings> users = query.getResultList();
		return users;

	}

	@Override
	public List<CarReadings> findByPriority(String id) {
		if (id == "HIGH") {
			return em.createNativeQuery(
					"SELECT * FROM Readings as r LEFT JOIN Car as v ON r.vin = v.vin WHERE convert_tz(r.timestamp,'+00:00',@@global.time_zone) > NOW() - INTERVAL 2 HOUR AND r.highPrioirty=1;",
					CarReadings.class).getResultList();

		} else if (id == "MEDIUM") {
			return em.createNativeQuery(
					"SELECT * FROM Readings as r LEFT JOIN Car as v ON r.vin = v.vin WHERE convert_tz(r.timestamp,'+00:00',@@global.time_zone) > NOW() - INTERVAL 1 HOUR AND r.midPrioirty=1;",
					CarReadings.class).getResultList();

		} else {
			return em.createNativeQuery(
					"SELECT * FROM Readings as r LEFT JOIN Car as v ON r.vin = v.vin WHERE convert_tz(r.timestamp,'+00:00',@@global.time_zone) > NOW() - INTERVAL 1 HOUR AND (r.lowPrioirty=1 || r.enginePrioirty=1);",
					CarReadings.class).getResultList();
		}

	}

	@Override
	public List<Readings> findByRequired(String id, int time, String type) {
		// TypedQuery<Readings> query =
		// em.createNamedQuery("Readings.findByVin", Readings.class);
		// query.setParameter("pVin", id);
		if (type.compareToIgnoreCase("hour") == 1) {
			return em.createNativeQuery(
					"SELECT * FROM Readings as u where u.vin=:pVin  AND convert_tz(u.timestamp,'+00:00',@@global.time_zone) > NOW() - INTERVAL :pTime HOUR ORDER BY u.timestamp",
					Readings.class).setParameter("pVin", id).setParameter("pTime", time).getResultList();
		} else {
			return em.createNativeQuery(
					"SELECT * FROM Readings as u where u.vin=:pVin  AND convert_tz(u.timestamp,'+00:00',@@global.time_zone) > NOW() - INTERVAL :pTime MINUTE ORDER BY u.timestamp",
					Readings.class).setParameter("pVin", id).setParameter("pTime", time).getResultList();
		}
	}

	@Override
	public List<Readings> findByTime(String id, String time, String time2) {
		System.out.println(time2);
		return em
				.createNativeQuery(
						"SELECT * FROM Readings as u where u.vin=:pVin AND ( u.timestamp > :pTime && u.timestamp< :pSec) ;",
						Readings.class)
				.setParameter("pVin", id).setParameter("pTime", time).setParameter("pSec", time2).getResultList();
	}

}
