package com.xavi.rockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropellerService {

	@Autowired
	private PropellerRepository propellerRepository;

	public List<Propeller> getPropellers(Long rocketId) {
		return propellerRepository.findAllByRocketId(rocketId);
	}

	public List<Propeller> deletePropellers(Long rocketId) {
		return propellerRepository.deleteAllByRocketId(rocketId);
	}

	public Propeller updatePropeller(Long rocketId, Long propellerId, Propeller propellerToUpdate) {
		Propeller propeller = getPropeller(rocketId, propellerId);
		propeller.setMaxPower(propellerToUpdate.getMaxPower());
		return propellerRepository.save(propeller);
	}

	public Propeller getPropeller(Long rocketId, Long propellerId) {
		return propellerRepository.findByIdAndRocketId(propellerId, rocketId);
	}

	public Propeller deletePropeller(Long rocketId, Long propellerId) {
		Propeller propeller = getPropeller(rocketId, propellerId);
		propellerRepository.deleteById(propellerId);
		return propeller;
	}
}
