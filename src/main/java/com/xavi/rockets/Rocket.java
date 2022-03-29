package com.xavi.rockets;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rocket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String code;

	@OneToMany(mappedBy = "rocket")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Propeller> propellers = new ArrayList<>();

	public Rocket() {
	}

	public Rocket(String code, ArrayList<Integer> propellers) throws Exception {
		checkCode(code);
		this.code = code;
		createPropellers(propellers);
	}

	private void createPropellers(ArrayList<Integer> propellers) throws Exception {
		checkNumberOfPropellers(propellers);
		for (Integer current : propellers) {
			this.propellers.add(new Propeller(current));
		}
	}

	private void checkCode(String code) throws Exception {
		if (!code.toUpperCase().matches("^[A-Z0-9]{8}$"))
			throw new Exception("El format del identificador no és vàlid");
	}

	private void checkNumberOfPropellers(List propellers) throws Exception {
		if (propellers.size() == 0) throw new Exception("El nombre de propulsors ha de ser superior a 0");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) throws Exception {
		checkCode(code);
		this.code = code;
	}

	public void throttlePropellers() {
		for (Propeller propeller : propellers) {
			propeller.throttle();
		}
	}

	public void brakePropellers() {
		for (Propeller propeller : propellers) {
			propeller.brake();
		}
	}

	public int currentPower() {
		return propellers.stream()
				.mapToInt(Propeller::getCurrentPower)
				.sum();
	}
	/*
	public void addPropellers(List<Propeller> propellerList){
		for(Propeller propeller : propellerList){
			propellers.add(propeller);
		}
	}
	*/
	public void addPropeller(Propeller propeller){
		propellers.add(propeller);
	}


	@Override
	public String toString() {
		return code + ": " + propellers;
	}
}
