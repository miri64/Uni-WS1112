public class SelectionSort extends Sort{

	public void sort(Comparable[] a, int left, int right) {
		for (int i = left; i < right; i++) {
			int indexOfMinimum = min(a, i, right);
			swapAtIndices(a, i, indexOfMinimum);
		}
	}

	private static int min(Comparable[] a, int startIndex, int endIndex) {
		int minIndex = startIndex;
		for (int i = startIndex; i <= endIndex; i++)
			if (a[i].compareTo(a[minIndex]) == -1)
				minIndex = i;
		return minIndex;
	}

	private static void swapAtIndices(Comparable[] a, int index1, int index2) {
		Comparable temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
