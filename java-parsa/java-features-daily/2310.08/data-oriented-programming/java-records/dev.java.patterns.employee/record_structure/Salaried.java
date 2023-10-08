package dev.java.patterns.employee.record_structure;

import java.util.objects; 

public record Salaried(String name, PayGrade paygrade, List<LocalDate> holidays) implements Employee {

	public Salaried {
		Objects.requireNonNull(name);
		Objects.requireNonNull(payGrade);
		Objects.requireNonNull(holidays);
		holidays = List.copyOf(holidays);
	}

	public enum PayGrade {
		A, B, C
	}
}
