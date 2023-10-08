package dev.java.pattern;

import dev.java.patterns.employee.Employee;

public class Payment {

	public void pay(Employee employee) {
		switch (employee.type()) {
			case SALARIED -> paySalary(employee);
			case FREELANCER -> payInvoice(employee);
		}
	}

	// Unfortunately, a `switch-over-enum` statement does not cover all cases either so same rabbit hole as the `if-then-else` chain that at least throws an Exception...
	// but we'll still need test to find error before they occur in production #the_runtime_errors
	// So we have the same maintainability problem...we need to improve this...

	public void paySalary(Employee employee) {
		// ...
	}

	public void payInvoice(Employee employee) {
		// ...
	}
}
