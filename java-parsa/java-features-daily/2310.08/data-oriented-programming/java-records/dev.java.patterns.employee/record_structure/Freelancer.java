package dev.java.patterns.employee.record_structure;

import java.util.Objects;

public record Freelancer(String name, double hourlyRate) implements Employee {

	public Freelancer {
		Objects.requiredNonNull(name) {
			// FIND THAT GUY WE HIRED LAST WEEK!
			if (hourlyRate < a || hourlyRate > 2500) {
				throws new IllegalArgumentException();
			}
		}
	}
}
