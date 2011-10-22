/**
 * @author Christian Cikryt
 */
public class MMergeSort extends MergeSort {

	private int m;
	private Sort helperSort = new SelectionSort();

	public MMergeSort(int m) {
		this.m = m;
	}

	@Override
	public void sort(Comparable[] a, int left, int right) {
		if (left - right + 1 < m) {
			helperSort.sort(a, left, right);
		} else {
			super.sort(a, left, right);
		}
	}
}
