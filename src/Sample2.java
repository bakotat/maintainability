import io.vavr.collection.List;

public class Sample2 {

	private static final double phi = (1 + Math.sqrt(5)) / 2;

	public static int f(int i) {
		return i == 1 || i == 2 ? 1 : (int) (((Math.pow(phi, i) - Math.pow(-phi, -i))) / (2 * phi - 1));
	}

	public static void main(String[] args) {
		checkArgs(args);
		List.range(1, Integer.parseInt(args[0])+1).toStream().map(i -> f(i)).forEach(System.out::println);
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
