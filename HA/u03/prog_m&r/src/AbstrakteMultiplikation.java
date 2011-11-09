import java.math.BigInteger;


public abstract class AbstrakteMultiplikation implements Multiplikation {
	
	private byte[] int_to_byte_array(int a) {
		return new byte[] {
				(byte)(a >>> 24),
				(byte)(a >>> 16),
				(byte)(a >>> 8),
				(byte) a
		};
	}

	@Override
	public BigInteger multipliziere(int a, int b) {
		BigInteger big_a = new BigInteger(int_to_byte_array(a));
		BigInteger big_b = new BigInteger(int_to_byte_array(b));
		return multipliziere(big_a, big_b);
	}

}
