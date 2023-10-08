package dev.java.patterns;

public class Payment {

	// When switching over complex types, the Java 21 compiler requires `exhaustivness`
	// Even though the `default` branch in the switch statement/expression guarantees `exhaustivness`, if we add another implementation of type employee, this exhaustiveness becomes less 
	// desirable since the compiler will not be able to remind us to implement the "unique" operations that come with this new added implementation
	// So it is important to avoid a `default` branch and list all `types` explicitly
	// Multiple types cannot be chained in on branch and in this case (worste case) we may have to repeat the same behaviour for different mutliple types, so here comes a Java 21 feature...
}
