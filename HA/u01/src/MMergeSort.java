public class MMergeSort extends MergeSort {

	private int m;
	private Sort helperSort = new SelectionSort();

	public MMergeSort(int m) {
		this.m = m;
	}

	@Override
	public int sort(Comparable[] a, int left, int right) {
		if (right - left+ 1 < m) {
			return helperSort.sort(a, left, right);
		} else {
			return super.sort(a, left, right);
		}
	}
}
