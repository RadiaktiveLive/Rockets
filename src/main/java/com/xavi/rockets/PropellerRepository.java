package com.xavi.rockets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PropellerRepository extends CrudRepository<Propeller, Long> {
	List<Propeller> findAllByRocketId(Long rocketId);
	List<Propeller> deleteAllByRocketId(Long rocketId);
}
