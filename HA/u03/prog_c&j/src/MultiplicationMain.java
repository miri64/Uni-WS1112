import java.math.BigInteger;
import java.util.Random;

public class MultiplicationMain {

	private static Measurement m = new Measurement(2);

	public static void main(String[] args) {
		System.out.println("Calculating starting at which bitsize the Karatsuba multiplication is more efficient...");
		System.out.println("Result: "+ compareAlgorithmsWithNumbersOfLength(1000));
		System.out.println("Calculating the optimal M for the MKaratsuba multiplication...");
		System.out.println("Result: "+ compareAlgorithmsForDifferentMs(1000));
	}

	private static int compareAlgorithmsWithNumbersOfLength(int n) {
		BigInteger a = createRandomNumber(n);
		BigInteger b = createRandomNumber(n);
		long[] results = m.measureTimeForDifferentExecutables(new KaratsubaExecutable(a, b), new SchoolMethodExecutable(a, b));
		if (firstIsEqualToSecond(results))
			return n;
		if (firstResultGreaterThanSecond(results)) {
			return compareAlgorithmsWithNumbersOfLength(n * 3);
		} else {
			return compareAlgorithmsWithNumbersOfLength(n / 2);
		}
	}
	
	private static int compareAlgorithmsForDifferentMs(int n) {
		BigInteger a = createRandomNumber(n);
		BigInteger b = createRandomNumber(n);
		int[] valuesForM = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 64, 128};
		Executable[] toTry = new Executable[valuesForM.length];
		for (int i = 0; i < valuesForM.length; i++)
			toTry[i] = new MKaratsubaExecutable(a, b, valuesForM[i]);
		long[] results = m.measureTimeForDifferentExecutables(toTry);
		return valuesForM[indexOfMinimum(results)];
	}

	private static int indexOfMinimum(long[] results) {
		if (results.length == 0)
			throw new IllegalArgumentException();
		int min = 0;
		for (int i = 1; i < results.length; i++) {
			if (results[i] < results[min])
				min = i;
		}
		return min;
	}

	private static boolean firstIsEqualToSecond(long[] results) {
		return Math.abs(results[0] - results[1]) < 1;
	}

	private static boolean firstResultGreaterThanSecond(long[] results) {
		return results[0] > results[1];
	}

	private static BigInteger createRandomNumber(int n) {
		Random random = new Random();
		return new BigInteger(n, random);
	}
}
