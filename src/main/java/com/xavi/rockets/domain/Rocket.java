package com.xavi.rockets.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	@JsonManagedReference
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

	public List<Propeller> getPropellers() {
		return propellers;
	}

	public void setPropellers(List<Propeller> propellers) {
		this.propellers = propellers;
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

	@JsonProperty("currentPower")
	public int currentPower() {
		return propellers.stream()
				.mapToInt(Propeller::getCurrentPower)
				.sum();
	}

	public void addPropeller(Propeller propeller) {
		propellers.add(propeller);
	}

	@Override
	public String toString() {
		return code + ": " + propellers;
	}
}
