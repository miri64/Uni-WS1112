import java.util.Arrays;

public class MergeSort extends Sort {
	
	public int sort(Comparable[] a, int left, int right) {
		int compareCount = 0;
		if (left >= right)
			return compareCount;
		int middle = (left + right) / 2;
		compareCount += sort(a, left,  middle);
		compareCount += sort(a, middle + 1, right);
		compareCount += merge(a, left, middle, right);
		return compareCount;
	}

	private static int merge(Comparable[] a, int left, int middle, int right) {
		int compareCount = 0;
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
			compareCount++;
		}
		if (leftPointer > middle)
			copy(a, temp, rightPointer, right, resultPointer - rightPointer);
		else
			copy(a, temp, leftPointer, middle, resultPointer - leftPointer);

		copy(temp, a, 0, temp.length - 1, left);
		return compareCount;
	}

	private static void copy(Object[] from, Object[] to, int left, int right, int resultPos) {
		for (int i = left; i <= right; i++)
			to[resultPos + i] = from[i];
	}

	@Override
	public String toString() {
		return "MergeSort";
	}
}
