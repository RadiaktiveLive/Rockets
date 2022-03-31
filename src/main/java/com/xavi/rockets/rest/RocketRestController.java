package com.xavi.rockets.rest;

import com.xavi.rockets.domain.Movement;
import com.xavi.rockets.domain.Propeller;
import com.xavi.rockets.domain.Rocket;
import com.xavi.rockets.service.PropellerService;
import com.xavi.rockets.service.RocketService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class RocketRestController {

	private RocketService rocketService;
	private PropellerService propellerService;

	public RocketRestController(RocketService rocketService, PropellerService propellerService) {
		this.rocketService = rocketService;
		this.propellerService = propellerService;
	}

	@PostMapping("/rockets")
	public Rocket addRocket(@RequestBody Rocket rocket) {
		return rocketService.addRocket(rocket);
	}

	@GetMapping("/rockets")
	public List<Rocket> getRockets() {
		return rocketService.getRockets();
	}

	@DeleteMapping("/rockets")
	public List<Rocket> deleteRockets() {
		return rocketService.deleteRockets();
	}

	///////////////////////////

	@PostMapping("/rockets/{rocketId}/movement")
	public Rocket moveRocket(@PathVariable Long rocketId, @RequestBody Movement movement) {
		Rocket rocket = rocketService.getRocket(rocketId);
		rocketService.moveRocket(rocket, movement);
		return rocket;
	}

	@PutMapping("/rockets/{rocketId}")
	public Rocket updateRocket(@PathVariable Long rocketId, @RequestBody Rocket rocket) throws Exception {
		return rocketService.updateRocket(rocketId, rocket);
	}

	@GetMapping("/rockets/{rocketId}")
	public Rocket getRocket(@PathVariable Long rocketId) {
		return rocketService.getRocket(rocketId);
	}

	@DeleteMapping("/rockets/{rocketId}")
	public Rocket deleteRocket(@PathVariable Long rocketId) {
		return rocketService.deleteRocket(rocketId);
	}

	///////////////////////////

	@PostMapping("/rockets/{rocketId}/propellers")
	public Propeller addPropeller(@PathVariable Long rocketId, @RequestBody Propeller propeller) {
		return rocketService.addPropeller(rocketId, propeller);
	}

	@GetMapping("/rockets/{rocketId}/propellers")
	public List<Propeller> getPropellers(@PathVariable Long rocketId) {
		return propellerService.getPropellers(rocketId);
	}

	@DeleteMapping("/rockets/{rocketId}/propellers")
	public List<Propeller> deletePropellers(@PathVariable Long rocketId) {
		return propellerService.deletePropellers(rocketId);
	}

	///////////////////////////

	@PutMapping("/rockets/{rocketId}/propellers/{propellerId}")
	public Propeller updatePropeller(@PathVariable Long rocketId, @PathVariable Long propellerId, @RequestBody Propeller propeller) {
		return propellerService.updatePropeller(rocketId, propellerId, propeller);
	}

	@GetMapping("/rockets/{rocketId}/propellers/{propellerId}")
	public Propeller getPropeller(@PathVariable Long rocketId, @PathVariable Long propellerId) {
		return propellerService.getPropeller(rocketId, propellerId);
	}

	@DeleteMapping("/rockets/{rocketId}/propellers/{propellerId}")
	public Propeller deletePropeller(@PathVariable Long rocketId, @PathVariable Long propellerId) {
		return propellerService.deletePropeller(rocketId, propellerId);
	}
}
