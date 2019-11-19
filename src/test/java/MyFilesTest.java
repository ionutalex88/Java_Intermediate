import org.junit.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MyFilesTest {

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

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() throws IOException {
        System.out.println("@Test - test_method_2");

        MyFileWriter myFileWriter = new MyFileWriter();
        myFileWriter.writeInFile(MyFileReader.externalFilesDir + "/MyTest2.txt", "How are you?");
        myFileWriter.writeLineInFile(MyFileReader.externalFilesDir + "/MyTest2.txt", "This is a new line");
        myFileWriter.writeInFile(MyFileReader.externalFilesDir + "/MyTest2.txt", "How are you?");

        MyFileReader myFileReader = new MyFileReader();
        String content = myFileReader.readFile(MyFileReader.externalFilesDir + "/MyTest2.txt");

        Assert.assertTrue(content.contains("How are you?"));
        System.out.println(content);
    }

    @Test
    public void test_method_3() throws IOException {
        System.out.println("@Test - test_method_3");

        MyFileReader myFileReader = new MyFileReader();
        List<String> fileLines = myFileReader.readFileLines(MyFileReader.externalFilesDir + "/MyTest.txt");

        Assert.assertTrue(fileLines.contains("I am"));
    }

    @Test
    public void test_method_4() throws IOException {
        System.out.println("@Test - test_method_4");

        MyFileScanner myFileScanner = new MyFileScanner();
        List<String> fileWords = myFileScanner.scanWords(MyFileReader.externalFilesDir + "/MyTest.txt");

        Assert.assertTrue(fileWords.contains("world!"));

        for (String word: fileWords
             ) {
            System.out.println(word);
        }
    }

    @Test
    public void test_method_5() throws IOException {
        System.out.println("@Test - test_method_5");

        MyPropertyReader myPropertyReader = new MyPropertyReader();
        Properties userProperties = myPropertyReader.readProperties(MyFileReader.externalFilesDir + "/MyPropertyFile");

        Assert.assertTrue(userProperties.getProperty("UserName").equals("Ionut"));
    }



}