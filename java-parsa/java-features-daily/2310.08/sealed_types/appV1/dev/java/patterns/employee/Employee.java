package dev.java.patterns.employee;

public sealed interface Employee permits Salaeried, Freelancer, Contractor {

	// Everytime I add a new implementation of the Employee interface, in this case Contractor, the `sealed type` mechanism in Java 21 simplifies the 
	// `Visitor pattern` where we can separate `types` from `operations` while making sure that adding a new type forces us to update all the operations to handle it
	// Thus way, we get the same safety - and all we have to do is to make the Employee type `sealed` and avoid `default` branches

	String name();
}
