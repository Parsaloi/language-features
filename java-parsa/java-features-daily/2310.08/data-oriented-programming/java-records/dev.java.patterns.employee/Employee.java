package dev.java.patterns.employee;

public sealed interface Employee permits Salaried, Freelancer {

	String name();
}
