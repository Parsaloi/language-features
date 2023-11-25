///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.working_with_streams.collecting_into_maps;

import static java.lang.System.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import java.util.UUID;

public class CollectingIntoMapsService {

	private static final Logger logger = Logger.getLogger(CollectingIntoMapsService.class.getName());

	public record Doctor(int uuid, String name) {}

	public static Stream<Doctor> doctors() {
		return Stream.of(new Doctor(101, "Dr. Kelvin"), new Doctor(102, "Dr. Hacker"), new Doctor(103, "Bebe"));
	}

    	public static void main(String... args) throws IOException {

		Map<Integer, String> uuidToName = doctors().collect(
				Collectors.toMap(Doctor::uuid, Doctor::name));
		logger.info("uuidToName: " + uuidToName);


		Map<Integer, Doctor> uuidToDoctor = doctors().collect(
				Collectors.toMap(Doctor::uuid, Function.identity()));
		logger.info("uuidToDoctor: " + uuidToDoctor.getClass().getName() + uuidToDoctor);


		uuidToDoctor = doctors().collect(
				Collectors.toMap(Doctor::uuid, Function.identity(),
					(existingValue, newValue) -> {
						throw new IllegalStateException();
					}, TreeMap::new));
		logger.info("uuidToDoctor: " + uuidToDoctor.getClass().getName() + uuidToDoctor);


		Stream<Locale> locales = 
			Stream.of(Locale.getAvailableLocales());
		Map<String, String> lingoNames = locales.collect(
				Collectors.toMap(
					Locale::getDisplayLanguage,
					l -> l.getDisplayLanguage(l),
					(existingValue, newValue) -> existingValue));
		//logger.info("lingoNames: " + lingoNames);


		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> countryLingoSets = 
			locales.collect(
					Collectors.toMap(
						Locale::getDisplayCountry,
						l -> Set.of(l.getDisplayLanguage()),
						(a, b) -> {
							//logger.info("A union of a and b is happening");
							Set<String> union = new HashSet<>(a);
							union.addAll(b);
							return union;
						}));
		//logger.info("countryLingoSets: " + countryLingoSets);
    	}
}
