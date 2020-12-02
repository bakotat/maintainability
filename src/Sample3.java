import io.vavr.collection.List;

public class Sample3 {

	public static int f(int i) {
		return (i == 0 || i == 1) ? 1 : f(i - 1) + f(i - 2);
	}

	public static void main(String[] args) {
		checkArgs(args);
		List.range(0, Integer.parseInt(args[0])).toStream().map(i -> f(i)).forEach(System.out::println);
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
