public class Snippet {

	int parseBinary(String binary) {
		return switch(binary) {
			case "00": yield 0;
			case "01": yield 1;
			// ...
			default: yield 1_00_000;
		};
	}
}
