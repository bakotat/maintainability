/**
 * This is the main class of the Fibonacci application. Its responsibility is to
 * dump the first N Fibinacci numbers
 * 
 * @author Tibor
 *
 */
public class Sample1 {

	public static int f(int i) {
		int prev = 1, curr = 1;
		for (int j = 1; j < i; j++) {
			int tmp = curr;
			curr = prev + curr;
			prev = tmp;
		}
		return curr;
	}

	public static void main(String[] args) {
		checkArgs(args);
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			System.out.println(f(i));
		}
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
