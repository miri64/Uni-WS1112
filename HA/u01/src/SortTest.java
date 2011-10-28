import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class SortTest {

	@Test
	public void testParseArray() {
		String input = "[1,10,20]";
		int[] expected = {1, 10, 20 };
		assertTrue(Arrays.equals(expected, SortMain.parseArrayString(input)));
	}
	public void testSortWithDifferentLengths(int[] lengths, int[] ms) {
		for (int n : lengths) {
			testSortWithDiffentMs(n, ms);
		}
	}

	public void testSortWithDiffentMs(int length, int[] ms) {
		for (int m : ms)
			sortArrays(length, m);
	}

	public void sortArrays(int length, int m) {
		testSortArray(generateTestArray(length, 2000), m);
	}

	public Comparable[] generateTestArray(int length, int greatestNumber) {
		Integer[] res = new Integer[length];
		Random randomGenerator = new Random();
		for (int i = 0; i < res.length; i++) {
			res[i] = randomGenerator.nextInt(greatestNumber);
		}
		return res;

	}

	public void testSortArray(Comparable[] a, int m) {
		Sort[] algorithms = {new MergeSort(), new MMergeSort(m)};
		long time;
		System.out.println("Array length: " + a.length + ". M:" + m);
		for (Sort s : algorithms) {
			Comparable[] toSort = Arrays.copyOf(a, a.length);
			time = measureTimeToSort(toSort, s);
			// assertTrue(isSorted(toSort));
		}
	}

	public long measureTimeToSort(Comparable[] a, Sort s) {
		System.gc();
		long start = System.currentTimeMillis();
		int compareCount = s.sort(a);
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("Number of compares with "+ s + " = "+ compareCount + ". Time: " + duration + "ms.");
		return duration;
	}

	public boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++)
			if (a[i].compareTo(a[i + 1]) == 1)
				return false;
		return true;
	}
}