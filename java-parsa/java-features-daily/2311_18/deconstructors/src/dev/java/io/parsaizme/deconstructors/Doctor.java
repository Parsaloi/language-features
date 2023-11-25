///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.deconstructors;

import static java.lang.System.*;

import java.util.*;
import java.time.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Doctor {

	private static final Logger logger = Logger.getLogger(Doctor.class.getName());

	private static record ResidentDoctor(int uuid, String officialName, String nickName) {};

	private static record Address(int postalCode) {};

	private static record AttendingDoctor(ResidentDoctor residentDoctor, Address address) {};

	//ResidentDoctor foundingResident = new ResidentDoctor(101, "Kelvin", "Voke"); // Non-static!!
	//Address address = new Address(...);
	//AttendingDoctor attendingDoctor = new AttendingDoctor(foundingResident, address);

    	public static void main(String... args) {

		ResidentDoctor foundingResident = new ResidentDoctor(101, "Kelvin", "Voke");
		Address address = new Address(0100);
		AttendingDoctor attendingDoctor = new AttendingDoctor(foundingResident, address);

		logger.info("A Deconstructor is about extracting data from an object...");
		logger.info("Record patterns match on position and compatible type as long as the declared pattern varaibles are of compatible type...");
		logger.info("...it's valid");

		logger.info("Here VAR - local variable type inference [JDK10] is being used instead of <string> and the names of the patter variables...");
		logger.info("...and the names of the pattern variables differ from the names of the record components");
		if(foundingResident instanceof ResidentDoctor(var uuid, var formalName, var casualName)) {
			logger.info("record contents >> " + uuid + ", " + formalName + " has a nick name >> " + casualName);
		}

		logger.info("With the addition of pattern matching for switch [JDK21] records patterns can be used in switch blocks");
		logger.info("...here using aswitch further simplifies the code");
		//String printRecord = switch(attendingDoctor){
		//	case ResidentDoctor(var fName, var cName, var fkName) -> cName + ", " + fname + " " + fkName;
		//};

		logger.info("Record patterns could be nested, however MY EXPERIMENT FOR THIS FEATURE FAILED!!");
		//if (attendindDoctor instanceof AttendingDoctor(

		//			var ResidentDoctor(var formalName, var casualName), 
		//			var Address(var postalCode))) 
		//{
		//	logger.info(casualName + ", " + formalName + " address is " + postalCode);
		//}
        }
}
