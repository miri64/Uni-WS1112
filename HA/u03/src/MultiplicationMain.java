import java.math.BigInteger;
import java.util.Random;

/**
 * @author Christian Cikryt
 */
public class MultiplicationMain {

	private static Measurement m = new Measurement(2);

	public static void main(String[] args) {
		System.out.println(compareAlgorithmsWithNumbersOfLength(1000));
	}

	private static int compareAlgorithmsWithNumbersOfLength(int n) {
		BigInteger a = createRandomNumber(n);
		BigInteger b = createRandomNumber(n);
		long[] results = m.measureTimeForDifferentExecutables(new KaratsubaExecutable(a, b), new SchoolMethodExecutable(a, b));
		if (firstIsEqualToSecond(results))
			return n;
		if (firstResultGreaterThanSecond(results)) {
			return compareAlgorithmsWithNumbersOfLength(n * 2);
		} else {
			return compareAlgorithmsWithNumbersOfLength(n / 2);
		}
	}

	private static boolean firstIsEqualToSecond(long[] results) {
		return Math.abs(results[0] - results[1]) < 2;
	}

	private static boolean firstResultGreaterThanSecond(long[] results) {
		return results[0] > results[1];
	}

	private static BigInteger createRandomNumber(int n) {
		Random random = new Random();
		return new BigInteger(n, random);
	}
}
