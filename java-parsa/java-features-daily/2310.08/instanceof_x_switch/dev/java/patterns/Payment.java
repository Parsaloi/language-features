package dev.java.pattern;

import dev.java.patterns.employee.Employee;
import dev.java.patterns.employee.Freelancer;
import dev.java.patterns.employee.Salaried;

public class Payment {

	public void pay(Employee employee) {
		switch (employee) {
			case Salaried salaried -> paySalary(employee);
			case Freelancer freelancer -> payInvoice(employee);
			default -> throw new IllegalArgumentException();
		}
	}

	// Unfortunately, a `switch-over-enum` statement does not cover all cases either so same rabbit hole as the `if-then-else` chain that at least throws an Exception...
	// but we'll still need test to find error before they occur in production #the_runtime_errors
	// So we have the same maintainability problem...we need to improve this...
	//
	// Here we are using the two approaches...with the instanceof-on-switch_statement

	public void paySalary(Salaried employee) {
		// ...
	}

	public void payInvoice(Freelancer employee) {
		// ...
	}
}
