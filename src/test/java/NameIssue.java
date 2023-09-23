
import static net.datafaker.transformations.Field.field;

import java.util.List;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import net.datafaker.transformations.CsvTransformer;
import net.datafaker.transformations.Schema;

/**
 * @author jyoti.chabria
 */
public class NameIssue {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Name name = faker.name();
        System.out.println(name.firstName());
        System.out.println(name.fullName());

    }
}
