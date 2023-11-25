///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.collections_api.work_with_maps;

import static java.lang.System.*;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.util.*;
import java.util.List;

enum MaasaiNumbers {
	NABO("nabo"), ARE("are"), UNI("uni");

	private String smallLetter;

	MaasaiNumbers(String smallLetter) {
		this.smallLetter = smallLetter;
	}

	// automatically private
	public String getSmallLetter() {
		return smallLetter;
	}

}

public class SimpleMap {

	private static final Logger logger = Logger.getLogger(SimpleMap.class.getName());

	private final Map<Integer, String> map = new HashMap<>();

	private static boolean keepLearning = true;

	private final List<Integer>keys = new ArrayList<>();

	public static void main(String... args) {

		logger.info("Devops Zone");

		logger.info("Client Frontend  GUI");
		EventQueue.invokeLater(() -> {
			var frame = new FrontEndFrame();
			frame.setTitle("Simple Map");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

		while(keepLearning) {

			logger.info("You fail twice you start again from sratch");
			
			try {

				var acceptInput = new Scanner(System.in);
                		System.out.print("Write 1,2,3 in Maasai: (NABO, ARE, UNI)");
                		String receivedInput = acceptInput.next().toUpperCase();
                		MaasaiNumbers maasaiNumber = Enum.valueOf(MaasaiNumbers.class, receivedInput);
                		System.out.println("You have written=" + maasaiNumber);
                		System.out.println("smallLetter=" + maasaiNumber.getSmallLetter());

				if ((maasaiNumber == maasaiNumber.NABO) || (maasaiNumber == maasaiNumber.ARE) || (maasaiNumber == maasaiNumber.UNI)) {
					logger.info("Good job! You wrote " + maasaiNumber  + " in Maasai correctly");

				} else {
					keepLearning = true;
				}

			} catch (IllegalArgumentException wrongInput) {

				keepLearning = true;
				logger.info("Hey Mlami, learn Maasai or GO HOME!");
                        	logger.info("Now Builder Parsa, we can do a couple of things better to empower Mlami to learn Maasai well, for instance:");
                        	logger.info("Leveraging Java Records and Pattern Matching for Switch to check for multiple conditions in a switch code block");
                        	logger.info("Use a Non-Blocking feature like the one in the Vert.x toolkit");

				logger.info("Oh! Oh! Fail this one and your start from scratch!");
				var acceptInput = new Scanner(System.in);
                        	System.out.print("Write 1,2,3 in Maasai: (NABO, ARE, UNI)");
                        	String receivedInput = acceptInput.next().toUpperCase();
                        	MaasaiNumbers maasaiNumber = Enum.valueOf(MaasaiNumbers.class, receivedInput);
                        	System.out.println("You have written=" + maasaiNumber);
                        	System.out.println("smallLetter=" + maasaiNumber.getSmallLetter());

                        	if ((maasaiNumber == maasaiNumber.NABO) || (maasaiNumber == maasaiNumber.ARE) || (maasaiNumber == maasaiNumber.UNI)) {
                                	logger.info("Good job! You wrote " + maasaiNumber  + " in Maasai correctly");

                        	} else {
                                	keepLearning = true;
                        	}
			}
		}
	}
}

class FrontEndFrame extends JFrame {

	public FrontEndFrame() {
		add(new FrontEndComponent());
		pack();
	}
}

class FrontEndComponent extends JComponent {

	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;

	private static final int DEFAULT_WIDTH = 480;
	private static final int DEFAULT_HEIGHT = 270;

	public void paintComponent(Graphics gDraw) {

		//gDraw.drawString("Demonstrating a the workings of the Java HashMap\n", MESSAGE_X, MESSAGE_Y);
		//gDraw.drawString("1. Nabo\n", MESSAGE_X, MESSAGE_Y);
		//gDraw.drawString("2. Are\n", MESSAGE_X, MESSAGE_Y);
		gDraw.drawString("3. Uni", MESSAGE_X, MESSAGE_Y);

	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
