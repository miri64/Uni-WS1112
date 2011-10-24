/**
 * @author Christian Cikryt
 */
public abstract class Sort {
	public void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	public abstract void sort(Comparable[] a, int left, int right);
}
