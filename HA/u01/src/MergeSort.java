import java.util.Arrays;

/**
 * @author Christian Cikryt
 */
public class MergeSort extends Sort {
	public void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	public void sort(Comparable[] a, int left, int right) {
		if (left >= right)
			return;
		int middle = (left + right) / 2;
		sort(a, left,  middle);
		sort(a, middle + 1, right);
		merge(a, left, middle, right);
	}

	private static void merge(Comparable[] a, int left, int middle, int right) {
		Comparable[] temp = new Comparable[right - left + 1];
		int leftPointer = left;
		int rightPointer = middle + 1;
		int resultPointer = 0;
		for (; leftPointer <= middle && rightPointer <= right; resultPointer++) {
			if (a[leftPointer].compareTo(a[rightPointer]) == -1) {
				temp[resultPointer] = a[leftPointer];
				leftPointer++;
			} else {
				temp[resultPointer] = a[rightPointer];
				rightPointer++;
			}
		}
		if (leftPointer > middle)
			copy(a, temp, rightPointer, right, resultPointer - rightPointer);
		else
			copy(a, temp, leftPointer, middle, resultPointer - leftPointer);

		copy(temp, a, 0, temp.length - 1, left);
	}

	private static void copy(Object[] from, Object[] to, int left, int right, int resultPos) {
		for (int i = left; i <= right; i++)
			to[resultPos + i] = from[i];
	}
}
