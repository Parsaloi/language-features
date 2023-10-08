package dev.java.patterns;

import dev.java.patterns.employee.Employee;
import dev.java.patterns.employee.Freelancer;
import dev.java.patterns.employee.Salaried;

public class Payment {

	public void pay(Employee employee) {
		// With a simple `if (employee instance of Freelancer freelancer)` we now get type check, a new variable of the desired type and name, and the old variable cast into it...
		// We can now use the new variable `freelancer` everywhere where the condition is true, in this case in the `if-branch`
		// Now if you would want multiple instances of employee to be handled different, you will enter the if-loop rabbit hole
		// Maintanability problem alert!!
		if (employee instanceof Freelancer freelancer) {
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
