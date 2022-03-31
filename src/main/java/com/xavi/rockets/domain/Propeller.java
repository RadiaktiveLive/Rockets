package com.xavi.rockets.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Propeller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private int maxPower;
	private int currentPower = 0;
	private static final int POWER_STEP = 10;

	@ManyToOne
	@JoinColumn(name = "rocket_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Rocket rocket;

	public Propeller() {
	}

	public Propeller(int maxPower) throws Exception {
		checkMaxPower(maxPower);
		this.maxPower = maxPower;
	}

	private void checkMaxPower(int maxPower) throws Exception {
		if (maxPower <= 0) throw new Exception("La potència ha de ser superior a 0");
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public Long getId() {
		return id;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}

	public void throttle() {
		currentPower += POWER_STEP;
		if (currentPower > maxPower) {
			currentPower = maxPower;
		}
	}

	public void brake() {
		currentPower -= POWER_STEP;
		if (currentPower < 0) {
			currentPower = 0;
		}
	}

	@Override
	public String toString() {
		return "" + maxPower;
	}
}
