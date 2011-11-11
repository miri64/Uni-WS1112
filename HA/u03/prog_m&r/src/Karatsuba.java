import java.math.BigInteger;

public class Karatsuba extends AbstrakteMultiplikation {

	@Override
	public BigInteger multipliziere(BigInteger a, BigInteger b) {
		int _2n = Math.max(a.bitLength(), b.bitLength());
		
		if (_2n <= 1) {
			return a.multiply(b);	// Rekursionsanker
		}
		
		int n = _2n / 2;
		
		BigInteger a_h = a.shiftRight(n); 				// a >>> n
		BigInteger a_l = a.subtract(a_h.shiftLeft(n));	// a - (a_h <<< n)
		
		BigInteger b_h = b.shiftRight(n); 				// b >>> n
		BigInteger b_l = b.subtract(b_h.shiftLeft(n));	// b - (b_h <<< n)
		
		// Rekursion
		BigInteger t1 = multipliziere(a_h, b_h);		// a_h * b_h
		BigInteger t2 = multipliziere(a_l, b_l);		// a_l * b_l
		BigInteger t3 = multipliziere(
				a_h.add(a_l), 
				b_h.add(b_l)
			);		// (a_h + a_l) * (b_h + b_l)
		
		BigInteger linksterm = t1.shiftLeft(2*n);
				// a_h * b_h * 2^2n
		BigInteger mittelterm = t3.subtract(t2).subtract(t1).shiftLeft(n); 
				// [(a_h + a_l) * (b_h + b_l) - a_l * b_l - a_h * b_h] * 2^n
		
		return linksterm.add(mittelterm).add(t2);	// Verknüpfung
	}

}
