import java.util.Vector;

// da Microsekunden sollten für Mittelwert und Streuung ganzzahlige Werte reichen
public class Stichprobe implements Comparable<Stichprobe> {
	Vector<Long> values;
	
	public Stichprobe() {
		values = new Vector<Long>();
	}
	
	public void add(long value) {
		values.add(value);
	}
	
	public long mittelwert() {
		if (values.size() == 0) {
			return 0;
		}
		
		long mittelwert = 0;
		for (Long l : values) {
			mittelwert += l.longValue();
		}
		return mittelwert/values.size();
	}
	
	// Mittlere Absolute Abweichung als Streuung
	public long maa() {
		if (values.isEmpty()) {
			return 0;
		}
		long maa = 0;
		long mittelwert = mittelwert();
		for (Long l : values) {
			maa += l.longValue()-mittelwert;
		}
		return maa/values.size();
	}

	@Override
	public int compareTo(Stichprobe o) {
		if (mittelwert() <= o.mittelwert() + o.maa() &&
				mittelwert() >= o.mittelwert() + o.maa()) {
			return 0;
		} else if (o.mittelwert() <= mittelwert() + maa() &&
				o.mittelwert() >= mittelwert() + maa()) {
			return 0;
		} else if (mittelwert() < o.mittelwert() - o.maa()) {
			return -1;
		} else if (mittelwert() + maa() < o.mittelwert()) {
			return -1;
		} else if (mittelwert() > o.mittelwert() + o.maa()) {
			return 1;
		} else {
			return 1;
		}
	}
}
