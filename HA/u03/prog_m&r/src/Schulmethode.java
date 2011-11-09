import java.math.BigInteger;

public class Schulmethode extends AbstrakteMultiplikation {

	final int ERGEBNIS = 0;
	final int REST = 1;
	
	@Override
	public BigInteger multipliziere(BigInteger a, BigInteger b) {
		BigInteger ergebnis = new BigInteger(new byte[]{0});
		BigInteger exponent = BigInteger.ONE;
		
		for (BigInteger b_ = b; 					// wähle rechten Faktor 
				b_.compareTo(BigInteger.ZERO) > 0; 	// solange der rechte Faktor nicht 0
				exponent = exponent.multiply(BigInteger.TEN)) { 
			BigInteger[] division = b_.divideAndRemainder(BigInteger.TEN);
			BigInteger ziffer = division[REST];		// Wähle letzte Ziffer
			BigInteger teilergebnis = a.multiply(ziffer);
			ergebnis = ergebnis.add(teilergebnis).multiply(exponent);
			b_ = division[ERGEBNIS];
													// und mult. diese mit linkem Faktor
		}
		
		return ergebnis;
	}

}
