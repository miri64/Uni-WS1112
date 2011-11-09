import org.junit.BeforeClass;

public class KaratsubaTest extends MultiplicationTest{

	@BeforeClass
	public static void initialize() {
		algorithm = new Karatsuba();
	}
}
