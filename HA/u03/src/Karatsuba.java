import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public class Karatsuba implements Multiplication {
	public BigInteger multiply(BigInteger a, BigInteger b) {
		int maxLength = Math.max(a.bitLength(), b.bitLength());
		if (maxLength <= 1)
			return a.multiply(b);
		int half = maxLength / 2 + maxLength % 2; // round up
		// a = ah + 2 ^ half * al
		BigInteger ah = a.shiftRight(half);
		BigInteger al = a.subtract(ah.shiftLeft(half));

		// b = bh + 2 ^ half * bl
		BigInteger bh = b.shiftRight(half);
		BigInteger bl = b.subtract(bh.shiftLeft(half));

		BigInteger ah_bh = multiply(ah, bh);
		BigInteger al_bl = multiply(al, bl);
		BigInteger ah_al__bh_bl = multiply(ah.add(al), bh.add(bl));

		// (a_h + a_l) * (b_h + b_l) - a_h * b_h - a_l * b_l = a_h * a_l + b_h * a_l
		BigInteger ah_bl__bh_al = ah_al__bh_bl.subtract(ah_bh).subtract(al_bl).shiftLeft(half);

		// a_h * b_h * 2^(2 * ceil(n/2)) + (a_h * b_l + b_h * a_l) * 2 ^ (ceil(n/2)) + a_l * b_l
		return ah_bh.shiftLeft(2 * half).add(ah_bl__bh_al).add(al_bl);
	}
}
