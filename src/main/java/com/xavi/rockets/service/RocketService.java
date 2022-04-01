package com.xavi.rockets.service;

import com.xavi.rockets.rest.vm.MovementVM;
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

	public void deleteRockets() {
		rocketRepository.deleteAll();
	}

	public Rocket updateRocket(Long rocketId, Rocket rocketToUpdate) throws Exception {
		Rocket rocket = getRocket(rocketId);
		rocket.setCode(rocketToUpdate.getCode());
		return rocketRepository.save(rocket);
	}

	public Rocket getRocket(Long rocketId) {
		return rocketRepository.findById(rocketId).get();
	}

	public void deleteRocket(Long rocketId) {
		Rocket rocket = getRocket(rocketId);
		rocketRepository.deleteById(rocketId);
	}

	public Propeller addPropeller(Long rocketId, Propeller propeller) {
		Rocket rocket = getRocket(rocketId);
		propeller.setRocket(rocket);
		return propellerRepository.save(propeller);
	}

	public Rocket moveRocket(Rocket rocket, MovementVM movementVM) {
		for (int i = 0; i < movementVM.getTimes(); i++) {
			if (movementVM.getMovementType().equals(MovementVM.ACCELERATE)) {
				rocket.throttlePropellers();
			} else if (movementVM.getMovementType().equals(MovementVM.BRAKE)) {
				rocket.brakePropellers();
			}
		}
		rocketRepository.save(rocket);
		return rocket;
	}
}
