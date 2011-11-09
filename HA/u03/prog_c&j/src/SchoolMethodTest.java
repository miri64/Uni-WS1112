import org.junit.BeforeClass;

public class SchoolMethodTest extends MultiplicationTest {
	
	@BeforeClass
	public static void initialize() {
		algorithm = new SchoolMethod();
	}
}
