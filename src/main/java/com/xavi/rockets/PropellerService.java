package com.xavi.rockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropellerService {

	@Autowired
	private PropellerRepository propellerRepository;

	public List<Propeller> getPropellers(Long rocketId){
		return propellerRepository.findAllByRocketId(rocketId);
	}

	public List<Propeller> deletePropellers(Long rocketId) {
		return propellerRepository.deleteAllByRocketId(rocketId);
	}
}
