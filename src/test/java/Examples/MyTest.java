package Examples;

import Example.FileRead;
import Example.FileScanner;
import Example.PropertyFileReader;
import Example.XmlReader;
import org.junit.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MyTest {

    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    //Byte read test
    @Test
    public void test_method_1() throws IOException, URISyntaxException {
        System.out.println("@Test - test_method_1");

        FileRead fileRead = new FileRead();
        String filename = "Test.txt";
        String content = fileRead.readFile(FileRead.pathToExternalSytemFolders + "/" + filename);
        System.out.println(content);
        Assert.assertTrue(content.contains("R. R. Martin."));


    }

    @Test
    public void test_method_2() throws IOException {
        System.out.println("@Test - test_method_2");

        FileRead fileRead = new FileRead();
        String filename = "Test.txt";

        List<String> lines = fileRead.readFileLines(FileRead.pathToExternalSytemFolders + "/" + filename);
        for (String line: lines) {
            System.out.println(line);
        }
        Assert.assertTrue(lines.contains("Apariţia unui pahar de Starbucks în cel mai recent episod \"Game of Thrones\" i-a pus pe jar pe fani! Mulţi dintre ei consideră că gafa producătorilor e un spoiler major, fiind un indiciu clar că Daenerys va gusta cafeaua aia execrabilă şi va sfârşi otrăvită."));
    }

    @Test
    public void test_method_3() throws IOException {
        System.out.println("@Test - test_method_3");

        FileScanner fileScanner = new FileScanner();
        String filename = "Test.txt";

        List<String> words = fileScanner.scanFile(FileRead.pathToExternalSytemFolders + "/" + filename);
        System.out.println(words.get(0));
        for (String word: words) {
            System.out.println(word);
        }
        Assert.assertTrue(words.contains("dragon,"));
    }

    @Test
    public void test_method_4() throws IOException {
        System.out.println("@Test - test_method_4");

        PropertyFileReader propertyFileReader = new PropertyFileReader();
        String filename = "config";

        Properties configs = propertyFileReader.readProperties(FileRead.pathToExternalSytemFolders +"/" + filename);
        Assert.assertTrue(configs.getProperty("browser").equals("chrome"));
    }

    @Test
    public void test_method_5() throws Exception {
        System.out.println("@Test - test_method_5");

        XmlReader xmlReader = new XmlReader();
        String filename = "config.xml";

        Document document = xmlReader.readXML(FileRead.pathToExternalSytemFolders +"/" + filename);
        HashMap config = xmlReader.profileLoader(document, "French");

        Assert.assertTrue(config.get("browser").equals("Firefox"));
    }

}