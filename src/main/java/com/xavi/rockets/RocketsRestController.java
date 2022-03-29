package com.xavi.rockets;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class RocketsRestController {

	private RocketsService rocketService;
	private PropellerService propellerService;

	public RocketsRestController(RocketsService rocketService, PropellerService propellerService) {
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

	@PostMapping("/rockets/{rocketId}")
	public Rocket moveRocket(@PathVariable String rocketId, @RequestBody String jsonString) {

		JSONObject jsonObject = new JSONObject(jsonString);
		int repeat = jsonObject.getInt("repeat");
		int operation = jsonObject.getInt("operation");

		return rocketService.moveRocket(rocketId, repeat, operation);
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
