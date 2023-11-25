///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.working_with_records;

import static java.lang.System.*;

import java.util.List;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SimpleRecord {

	private static final Logger logger = Logger.getLogger(SimpleRecord.class.getName());

	record SomeRange(int begin, int end) implements Iterable<Integer> {

		SomeRange{
			if (end < begin)
				throw new IllegalArgumentException("Begin is greater the end!");
		}

		SomeRange(int end) {
			this(0, end);
		}

		@Override
		public Iterator<Integer> iterator() {
			// An Anonymous class[] :)
			return new Iterator<>() {
				int index = begin;
				@Override
				public boolean hasNext() {
					return index < end;
				}

				@Override
				public Integer next() {
					return index++;
				}
			};
		}
	}

    	public static void main(String... args) {

		logger.info("Continuous Launching....");
		SomeRange range = new SomeRange(0, 5);
		logger.info("range = " + range);
		logger.info("begin=" + range.begin());
		logger.info("keep going...");

		for (var value : range) {
			logger.info("value = " + value);
		}
    	}
}
