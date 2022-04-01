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

	public Rocket(String code) throws Exception {
		checkCode(code);
		this.code = code;
	}

	private void checkCode(String code) throws Exception {
		if (!code.toUpperCase().matches("^[A-Z0-9]{8}$"))
			throw new Exception("El format del identificador no és vàlid");
	}

	public Long getId() {
		return id;
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

}
