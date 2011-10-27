public abstract class Sort {
	public int sort(Comparable[] a) {
		return sort(a, 0, a.length - 1);
	}

	public abstract int sort(Comparable[] a, int left, int right);
}
