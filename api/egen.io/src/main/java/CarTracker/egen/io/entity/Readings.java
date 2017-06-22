package CarTracker.egen.io.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "Readings.findByVin", query = "SELECT u FROM Readings u where u.vin=:pVin ORDER BY u.timestamp"),
	})
//@NamedQuery(name = "Readings.findByRequired", query = "SELECT u FROM Readings u where u.vin=:pVin AND convert_tz(u.timestamp,'+00:00','+05:30') > NOW() - INTERVAL 1 HOUR")
public class Readings {

	@Id
	private String id;
	private String vin;
	private float latitude;
	private float longitude;
	private Date timestamp;
	private float fuelVolume;
	private int speed;
	private boolean highPrioirty;
	private boolean midPrioirty;
	private boolean lowPrioirty;
	private boolean enginePrioirty;
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private int engineRpm;

	@OneToOne
	private Tires tires;

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}


	public boolean isHighPrioirty() {
		return highPrioirty;
	}

	public void setHighPrioirty(boolean highPrioirty) {
		this.highPrioirty = highPrioirty;
	}

	public boolean isMidPrioirty() {
		return midPrioirty;
	}

	public void setMidPrioirty(boolean midPrioirty) {
		this.midPrioirty = midPrioirty;
	}

	public boolean isLowPrioirty() {
		return lowPrioirty;
	}

	public void setLowPrioirty(boolean lowPrioirty) {
		this.lowPrioirty = lowPrioirty;
	}

	public boolean isEnginePrioirty() {
		return enginePrioirty;
	}

	public void setEnginePrioirty(boolean enginePrioirty) {
		this.enginePrioirty = enginePrioirty;
	}

	public Readings() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public int getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}

}
