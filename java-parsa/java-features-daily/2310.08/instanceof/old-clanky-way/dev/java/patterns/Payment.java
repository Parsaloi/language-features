package dev.java.patterns;

import dev.java.patterns.employee.Employee;
import dev.java.patterns.employee.Freelancer;
import dev.java.patterns.employee.Salaried;

public class Payment {

	public void pay(Employee employee) {
		if (employee instanceof Freelancer) {
			Freelancer freelancer = (Freelancer) employee;
			// use employee
		}
	}

	public void paySalary(Salaried employee) {
		// ...
	}

	public void payInvoice(Freelancer employee) {

	}
}
