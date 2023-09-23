import java.util.Random;
import net.datafaker.Faker;
import org.testng.Assert;

/**
 * @author jyoti.chabria
 */
public class IntegrationTest {
    public static void main(String args[]) {
        Faker fakerA = new Faker(new Random(0));
        Faker fakerB = new Faker(new Random(0));
        String aName = fakerA.name().firstName();
        String bName = fakerB.name().firstName();
        Assert.assertEquals(aName,bName);

    }

}
