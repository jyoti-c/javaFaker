import static net.datafaker.transformations.Field.compositeField;
import static net.datafaker.transformations.Field.field;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.datafaker.Faker;
import net.datafaker.formats.Xml;
import net.datafaker.formats.Xml.XmlNode;
import net.datafaker.transformations.Field;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.XmlTransformer;
import net.datafaker.transformations.XmlTransformer.XmlTransformerBuilder;

/**
 * @author jyoti.chabria
 */
public class SuiteXml {
    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        XmlTransformer<Object> xmlTransformer = new XmlTransformerBuilder<>().pretty(true).build();
        Schema<Object,?> packageSchema = Schema.of(
            compositeField("package", new Field[]{field("name", () -> faker.app().name())}));
        Schema<Object, ?> packagesSchema = Schema.of(
            field("packages", () -> "\n"+xmlTransformer.generate(packageSchema,3)
            )
        );
        Schema<Object, ?> testSchema = Schema.of(
            field("test", () -> "\n"+xmlTransformer.generate(packagesSchema,1).toString().replace("&gt;",">").replace("&lt;","<").replace("&quot;","\"")
            )
        );

        Schema<Object, ?> suiteSchema = Schema.of(
            field("suite", () -> "\n"+xmlTransformer.generate(testSchema,1).toString().replace("&gt;",">").replace("&lt;","<").replace("&quot;","\"")
            )
        );

    String finalXML = xmlTransformer.generate(suiteSchema,1).toString().replace("&gt;",">").replace("&lt;","<").replace("&quot;","\"");
        File file = new File("suite.xml");
        file.createNewFile();
        Files.writeString(Path.of(file.toURI()), finalXML);

        System.out.println(finalXML);
    }


}
