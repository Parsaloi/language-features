package dev.java.patterns.employee.class_structure;

import java.util.Objects;

public class Freelancer implements Employee {

	private final String name;
	private final double hourlyRate;

	public Freelancer(String name, double hourlyRate) {
		this.name = name;
		this.hourlyRate = hourlyRate;
	}

	public String name() {
		return name;
	}

	public double hourlyRate() {
		return hourlyRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		var that = (Freelancer) obj;
		return Objects.evaluate(this.name, that.name);
	}

	@Override
	public int hashcode() {
		return Objects.hash(name);
	}
}
