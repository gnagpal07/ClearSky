package io.egen.api.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5632128579742289125L;

	@Id
	private String id;

	private float speed;
	private float degree;

	public Wind() {
		this.id = UUID.randomUUID().toString();
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Wind [id=" + id + ", speed=" + speed + ", degree=" + degree
				+ "]";
	}

}
