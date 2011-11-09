import java.math.BigInteger;

public class SchoolMethodExecutable extends MultiplicationExecutable{
	protected SchoolMethodExecutable(BigInteger a, BigInteger b) {
		super(a, b);
		algorithm = new SchoolMethod();
	}
}
