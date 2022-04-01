package com.xavi.rockets.repository;

import com.xavi.rockets.domain.Propeller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropellerRepository extends CrudRepository<Propeller, Long> {
	List<Propeller> findAllByRocketId(Long rocketId);

	void deleteAllByRocketId(Long rocketId);

	Propeller findByIdAndRocketId(Long propellerId, Long rocketId);
}
