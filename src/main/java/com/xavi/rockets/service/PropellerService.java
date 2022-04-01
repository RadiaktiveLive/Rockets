package com.xavi.rockets.service;

import com.xavi.rockets.domain.Propeller;
import com.xavi.rockets.repository.PropellerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PropellerService {

	private PropellerRepository propellerRepository;

	public PropellerService(PropellerRepository propellerRepository) {
		this.propellerRepository = propellerRepository;
	}

	public List<Propeller> getPropellers(Long rocketId) {
		return propellerRepository.findAllByRocketId(rocketId);
	}

	public void deletePropellers(Long rocketId) {
		propellerRepository.deleteAllByRocketId(rocketId);
	}

	public Propeller updatePropeller(Long rocketId, Long propellerId, Propeller propellerToUpdate) throws Exception {
		Propeller propeller = getPropeller(rocketId, propellerId);
		propeller.setMaxPower(propellerToUpdate.getMaxPower());
		return propellerRepository.save(propeller);
	}

	public Propeller getPropeller(Long rocketId, Long propellerId) {
		return propellerRepository.findByIdAndRocketId(propellerId, rocketId);
	}

	public void deletePropeller(Long rocketId, Long propellerId) {
		Propeller propeller = getPropeller(rocketId, propellerId);
		propellerRepository.deleteById(propellerId);
	}
}
