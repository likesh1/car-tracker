package CarTracker.egen.io.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CarTracker.egen.io.constants.URI;
import CarTracker.egen.io.entity.CarReadings;
import CarTracker.egen.io.entity.Readings;
import CarTracker.egen.io.service.ReadingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.READINGS)
@Api(tags = "readings")
@CrossOrigin("*")
public class ReadingsController {

	private ReadingsService service;

	public ReadingsController(ReadingsService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
	@ApiOperation(value = "Find Car Readings by Vin", notes = "Returns a list of Readings of the car by Vin in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Readings> findAll(@PathVariable("id") String id) {
		return service.findByVin(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Readings", notes = "Creates a Reading in the app with for a particular car")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Readings create(@RequestBody Readings readings) {
		return service.create(readings);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.PRIORITY)
	@ApiOperation(value = "Get Priority Reading", notes = "Returns a list of cars by a particular Priority in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<CarReadings> findByPriority(@PathVariable("priority") String priority) {
		return service.findByPriority(priority);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.REQUIRED)
	@ApiOperation(value = "Find All Readings by last x hours", notes = "Returns a list oo readings for a car within a few hoursin the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Readings> findByRequired(@PathVariable("id") String id,@PathVariable("time") int time,@PathVariable("type") String type) {
		return service.findByRequired(id,time,type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.TIMES)
	@ApiOperation(value = "Find All Readings by a time period", notes = "Returns a list oo readings for a car within a particular time the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Readings> findByTime(@PathVariable("id") String id,@PathVariable("time") String time,@PathVariable("time2") String time2) {
		System.out.println(time2);
		return service.findByTime(id,time,time2);
	}
	

}