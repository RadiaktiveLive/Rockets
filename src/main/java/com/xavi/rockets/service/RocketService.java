package com.xavi.rockets.service;

import com.xavi.rockets.domain.Movement;
import com.xavi.rockets.domain.Propeller;
import com.xavi.rockets.domain.Rocket;
import com.xavi.rockets.repository.PropellerRepository;
import com.xavi.rockets.repository.RocketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RocketService {

	private RocketRepository rocketRepository;

	private PropellerRepository propellerRepository;

	public RocketService(RocketRepository rocketRepository, PropellerRepository propellerRepository) {
		this.rocketRepository = rocketRepository;
		this.propellerRepository = propellerRepository;
	}

	public Rocket addRocket(Rocket rocket) {
		return rocketRepository.save(rocket);
	}

	public List<Rocket> getRockets() {
		List<Rocket> rocketList = new ArrayList<>();
		for (Rocket rocket : rocketRepository.findAll()) {
			rocketList.add(rocket);
		}
		return rocketList;
	}

	public List<Rocket> deleteRockets() {
		List<Rocket> rocket = getRockets();
		rocketRepository.deleteAll();
		return rocket;
	}

	public Rocket updateRocket(Long rocketId, Rocket rocketToUpdate) throws Exception {
		Rocket rocket = getRocket(rocketId);
		rocket.setCode(rocketToUpdate.getCode());
		return rocketRepository.save(rocket);
	}

	public Rocket getRocket(Long rocketId) {
		return rocketRepository.findById(rocketId).get();
	}

	public Rocket deleteRocket(Long rocketId) {
		Rocket rocket = getRocket(rocketId);
		rocketRepository.deleteById(rocketId);
		return rocket;
	}

	public Propeller addPropeller(Long rocketId, Propeller propeller) {
		Rocket rocket = getRocket(rocketId);
		propeller.setRocket(rocket);
		return propellerRepository.save(propeller);
	}

	public Rocket moveRocket(Rocket rocket, Movement movement) {
		for (int i = 0; i < movement.getTimes(); i++) {
			if (movement.getMovementType().equals(Movement.ACCELERATE)) {
				rocket.throttlePropellers();
			} else if (movement.getMovementType().equals(Movement.BRAKE)) {
				rocket.brakePropellers();
			}
		}
		propellerRepository.saveAll(rocket.getPropellers());
		return rocket;
	}
}
