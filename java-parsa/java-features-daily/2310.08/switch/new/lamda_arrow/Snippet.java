class Snippet {

	void process(String binary) {
		switch(binary) {
			case "00" -> 
				process(0);
			case "01" ->
				process(1);
			case "10" -> 
				process(2);
			//..
			default ->
				process(1_00);
		};

		// This eliminates the fall through...which is the need for the breaks...
		// This style is recommended
	}
}
