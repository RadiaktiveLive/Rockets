package com.xavi.rockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RocketsService {
	@Autowired
	private RocketsRepository rocketRepository;

	@Autowired
	private PropellerRepository propellerRepository;

	public Rocket addRocket(Rocket rocket) {
		return rocketRepository.save(rocket);
	}

	public List<Rocket> getRockets() {
		List<Rocket> rocketList = new ArrayList<>();
		for(Rocket rocket : rocketRepository.findAll()){
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

	public Rocket deleteRocket(Long rocketId) {
		Rocket rocket = getRocket(rocketId);
		rocketRepository.deleteById(rocketId);
		return rocket;
	}

	public Rocket addPropeller(Long rocketId, Propeller propeller) {
		Rocket rocket = getRocket(rocketId);
		//rocket.addPropeller(propeller);
		propeller.setRocket(rocket);
		return propellerRepository.save(propeller).getRocket();
		//return rocketRepository.save(rocket);
		//return rocket;
	}
}
