package CarTracker.egen.io.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CarTracker.egen.io.entity.Tires;
import CarTracker.egen.io.repository.TiresRepository;
import CarTracker.egen.io.service.TiresService;

@Service
public class TiresServiceImpl implements TiresService{

private TiresRepository tiresrepository; 
	
	
	public TiresServiceImpl(TiresRepository tiresrepository) {
		this.tiresrepository = tiresrepository;
	}

	@Override
	@Transactional
	public Tires create(Tires tires) {
		
		return tiresrepository.create(tires);
	}

}
