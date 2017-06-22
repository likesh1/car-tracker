package CarTracker.egen.io.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import CarTracker.egen.io.entity.Tires;
import CarTracker.egen.io.repository.TiresRepository;

@Repository
public class TiresRepositoryImpl implements TiresRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tires create(Tires tires) {
		em.persist(tires);
		return tires;
	}

}
