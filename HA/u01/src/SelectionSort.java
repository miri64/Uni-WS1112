public class SelectionSort extends Sort{

	public int sort(Comparable[] a, int left, int right) {
		int compareCount	= 0;
		for (int i = left; i < right; i++) {
			int[] returnArray = min(a, i, right);
			int indexOfMinimum = returnArray[0];
			compareCount += returnArray[1];
			swapAtIndices(a, i, indexOfMinimum);
		}
		return compareCount;
	}

	private static int[] min(Comparable[] a, int startIndex, int endIndex) {
		int minIndex = startIndex;
		int compareCount = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (a[i].compareTo(a[minIndex]) == -1)
				minIndex = i;
			compareCount++;
		}
		int[] res = new int[2];
		res[0] = minIndex;
		res[1] = compareCount;
		return res;
	}

	private static void swapAtIndices(Comparable[] a, int index1, int index2) {
		Comparable temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	@Override
	public String toString() {
		return "SelectionSort";
	}
}
