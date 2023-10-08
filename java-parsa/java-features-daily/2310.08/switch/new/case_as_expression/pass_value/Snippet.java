public class Snippet {

	String binary = // ...
	int number = switch(binary) {
		case "00": yield 0;
		case "01": yield 1;
		case "10": yield 2;
		case "11": yield 3;
		default: yield 1_000_000;
	};
}
