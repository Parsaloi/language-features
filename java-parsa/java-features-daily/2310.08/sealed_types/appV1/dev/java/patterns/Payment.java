package dev.java.patterns;

import dev.java.patterns.employee.Employee;
import dev.java.patterns.employee.Freelancer;
import dev.java.patterns.employee.Salaried;

public class Payment {

	public void pay(Employee employee) {
		// When we make the Employee interface `sealed` now switch statement understands that we have covered all the cases for the permitted implementations
		switch (employee) {
			case Salaried salaried -> paySalary(salaried);
			case Freelancer freelancer -> payInvoice(freelancer);
		}
	}

	public void paySalary(Salaried employee) {
		// ...
	}

	public void payInvoice(Freelancer employee) {

	}
}
