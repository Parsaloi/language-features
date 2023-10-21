///usr/bin/env jbang "$0" "$@" ; exit $?

package stu.parsaizme.optional_api;

import static java.lang.System.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class OptionalReview {

	public static void main(String... args) throws IOException {

		var contents = Files.readString(Path.of("alice30.txt"));

		List<String> wordList = List.of(contents.split("\\PL+"));

		Optional<String> optionalValue = wordList.stream()
							.filter(s -> s.contains("fred"))
							.findFirst();

		System.out.println(optionalValue.orElse("No word") + " contains fred");

		Optional<String> optionalString = Optional.empty();
		String result = optionalString.orElse("N/A");
		System.out.println("result: " + result);
		result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());

		System.out.println("result: " + result);

		try {
			result = optionalString.orElseThrow(IllegalStateException::new);
			System.out.println("result: " + result);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		optionalValue = wordList.stream()
					.filter(s -> s.contains("red"))
					.findFirst();

		// Uncommenting BAD PRACTICE of concatinating strings
		// Commenting it back after confirming the StringBuilder is not the cause of error
		// optionalValue.ifPresent(s -> System.out.println(s + " contains red"));
		
		// Using StringBuilder here
		/* ----REMOVING BUILDER FOR TESTING PUPRPOSES-----
		 * REINSTATING IT BACK!
		 */
		var builder = new StringBuilder();
		optionalValue.ifPresent(s -> {
			builder.append(s + " contains red");
			System.out.println(builder.toString());
		});

		var results = new HashSet<String>();
		optionalValue.ifPresent(results::add);
		Optional<Boolean> added = optionalValue.map(results::add);
		System.out.println(added);

		System.out.println(inverse(4.0).flatMap(OptionalReview::squareRoot));

		System.out.println(inverse(-1.0).flatMap(OptionalReview::squareRoot));

		Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalReview::inverse).flatMap(OptionalReview::squareRoot);

		System.out.println(result2);
	}

	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	public static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}
}
