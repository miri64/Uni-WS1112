import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SortTest {

	@Test
	public void testSortArrays() {
		Integer[] a1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, 100, 100};
		testSortArray(a1);
	}

	public void testSortArray(Comparable[] a) {
		Sort[] algorithms = {new MergeSort(), new SelectionSort(), new MMergeSort(2)};
		long time;
		for (Sort s : algorithms) {
			Comparable[] toSort = Arrays.copyOf(a, a.length);
			time = measureTimeToSort(toSort, s);
			assertTrue(isSorted(toSort));
		}
	}

	public long measureTimeToSort(Comparable[] a, Sort s) {
		System.gc();
		long start = System.currentTimeMillis();
		s.sort(a);
		long end = System.currentTimeMillis();
		return end - start;
	}

	public boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++)
			if (a[i].compareTo(a[i + 1]) == 1)
				return false;
		return true;
	}
}
