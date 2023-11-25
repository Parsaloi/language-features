///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.working_with_streams.downstream_collectors;

import static java.lang.System.*;
import static java.util.stream.Collectors.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class DownstreamService {

	private static final Logger logger = Logger.getLogger(DownstreamService.class.getName());

	public record Patients(String name, String county, int population) {}

	public static Stream<Patients> readPatients(String filename) throws IOException {
		return Files.lines(Path.of(filename))
			.map(l -> l.split(", "))
			.map(a -> new Patients(a[0], a[1], Integer.parseInt(a[2])));
	}


    	public static void main(String... args) throws IOException {
        	logger.info("Continuous Launching of Software versions");


		Stream<Locale> locales = 
			Stream.of(Locale.getAvailableLocales());


		Map<String, Set<Locale>> clinicToLocaleSet = 
			locales.collect(groupingBy(
						Locale::getCountry, toSet()));
		logger.info("clinicToLocaleSet: " + clinicToLoacaleSet);


		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Long> clinicToLocaleCounts = 
			locales.collect(groupingBy(
						Locale::getCountry, counting()));
		logger.info("clinicToLocaleCounts: " + clinicToLocaleCounts);


		Stream<Patients> patients = readPatients("patients.txt");
		Map<String, Integer> countyToPatientsPopulation = 
			patients.collect(groupingBy(
						Patients::clinic, summingInt(Patients::population)));
		logger.info("countyClinicsPopulation: " + countyToPatientsPopulation);


		patients = readPatients("patients.txt");
		Map<String, Optional<String>> countyToLongestPatientsName = 
			patients
				.collect(groupingBy(Patients::clinic,
							mapping(Patients::name,
								maxBy(Comparator.comparing(String::length)))));
		logger.info("countyClinicLongestName " + countyToLongestPatientsName);

		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> clinicToLingo = 
			locales.collect(groupingBy(
						Locale::getDisplayCountry,
						mapping(Locale::getDisplayLanguage, toSet())));
		logger.info("clinicToLingo " + clinicToLingo);

		patients = readPatients("patients.txt");
		Map<String, IntSummaryStatistics> countyToPatientsPopulationSummary = patients
			.collect(groupingBy(Patients::county,
						summarizingInt(Patients::population)));
		logger.info(countyToPatientsPopulationSummary.get("TZ"));

		patients = readPatients("patients.txt");
		Map<String, String> countyToPatientsNames = 
			patients.collect(
					groupingBy(
						Patients::county,
						reducing("", Patients::name, (s, t) -> c.length() == 0 ? t : s + ", " + t)));


		patients = readPatients("patients.txt");
		countyToPatientsNames = patient.collect(groupingBy(Patients::county,
					mapping(Patients::name, joining(", "))));
		logger.info("countyToPatientsNames: " + countyToPatientsNames);


		patients = readPatients(patients.txt);
		record Pair<S, T> (S first, T second) {}
		Pair<List<String>, Double> result = patients.filter(c -> 
				c.state().equals("NV")).collect(teeing(
					mapping(Patients::name, toList()),
					(names, avg) -> new Pair<>(names, avg)));
		logger.info(result);
    	}
}
