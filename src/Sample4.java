import java.util.stream.Stream;

/**
 * This is the main class of the Fibonacci application. Its responsibility is to
 * dump the first N Fibinacci numbers
 * 
 * @author Tibor
 *
 */
public class Sample4 {

	public static void main(String[] args) {
		checkArgs(args);
		Stream.iterate(new int[] { 1, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(Integer.parseInt(args[0]))
				.map(t -> t[0]).forEach(System.out::println);
	}

	private static void checkArgs(String[] args) {
		if (args == null || args.length != 1 || !isInteger(args[0])) {
			// @formatter:off			
			System.out.println(new StringBuffer()
					.append("Usage:\n")
					.append("FibonacciApp N\n")
					.append("N - the first N Fibonacci numbers will be printed")
					.toString());
			// @formatter:on
			System.exit(0);
		}
	}

	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
