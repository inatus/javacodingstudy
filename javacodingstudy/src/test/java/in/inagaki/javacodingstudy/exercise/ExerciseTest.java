/**
 * 
 */
package in.inagaki.javacodingstudy.exercise;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Exerciseのテストクラス
 * 
 * @author inatus
 * 
 */
public class ExerciseTest {
    private Exercise testObject = new Exercise();

    /**
     * テストクラス実行前にディレクトリのすべてのファイルを削除します。
     * 
     * @throws java.lang.Exception
     *             ファイル削除時にエラーが発生した場合
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	File directory = new File("output/exercise");
	directory.mkdirs();
	FileUtils.cleanDirectory(new File("output/exercise"));
    }

    /**
     * テストクラス実行後にディレクトリのすべてのファイルを削除します。
     * 
     * @throws java.lang.Exception
     *             ファイル削除時にエラーが発生した場合
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	FileUtils.cleanDirectory(new File("output/exercise"));
    }

    /**
     * 引数で与えられるファイル名が存在し、引数で与えられる内容であるか検査します。
     * 
     * @param filePath
     *            検査するファイル名
     * @param expText
     *            検査するファイルの内容
     * @throws FileNotFoundException
     *             ファイルが存在しない場合
     * @throws IOException
     *             ファイルが読み込めない場合
     */
    private void assertFile(String filePath, String expText)
	    throws FileNotFoundException, IOException {
	File createdFile = new File(filePath);
	assertTrue(createdFile.exists());
	BufferedReader reader = new BufferedReader(new FileReader(createdFile));
	String text;
	while ((text = reader.readLine()) != null) {
	    assertEquals(expText, text);
	}
    }

    /**
     * ディレクトリが空でファイルを作成した場合に指定したファイル名・内容でファイルが作成できることをテストします。
     * 
     * @throws Exception
     *             ファイル入出力に関するエラーが発生した場合
     */
    @Test
    public void testCreateFile01() throws Exception {
	testObject.createFile("sample.txt", "Sample Text");
	assertFile("output/exercise/sample.txt", "Sample Text");
    }

    /**
     * ディレクトリに既にファイルが存在し、同じファイル名を指定した場合、
     * ファイル名の末尾に連番を付加し指定した内容でファイルが作成できることをテストします。
     * 
     * @throws Exception
     *             ファイル入出力に関するエラーが発生した場合
     */
    @Test
    public void testCreateFile02() throws Exception {
	testObject.createFile("sample.txt", "Sample Text2");
	assertFile("output/exercise/sample.txt", "Sample Text");
	assertFile("output/exercise/sample_1.txt", "Sample Text2");
    }

    /**
     * ディレクトリに既にファイルが存在し、同じファイル名を指定した場合、
     * ファイル名の末尾に連番を付加し指定した内容でファイルが作成できることをテストします。
     * 
     * @throws Exception
     *             ファイル入出力に関するエラーが発生した場合
     */
    @Test
    public void testCreateFile03() throws Exception {
	testObject.createFile("sample.txt", "Sample Text3");
	assertFile("output/exercise/sample.txt", "Sample Text");
	assertFile("output/exercise/sample_1.txt", "Sample Text2");
	assertFile("output/exercise/sample_2.txt", "Sample Text3");
    }

    /**
     * ディレクトリに既にファイルが存在し、別のファイル名を指定した場合、指定したファイル名・内容でファイルが作成できることをテストします。
     * 
     * @throws Exception
     *             ファイル入出力に関するエラーが発生した場合
     */
    @Test
    public void testCreateFile04() throws Exception {
	testObject.createFile("different.txt", "aaaaaaa");
	assertFile("output/exercise/sample.txt", "Sample Text");
	assertFile("output/exercise/sample_1.txt", "Sample Text2");
	assertFile("output/exercise/sample_2.txt", "Sample Text3");
	assertFile("output/exercise/different.txt", "aaaaaaa");
    }

    /**
     * ディレクトリに既にファイルが存在し、同じファイル名を指定した場合、
     * ファイル名の末尾に連番を付加し指定した内容でファイルが作成できることをテストします。
     * 
     * @throws Exception
     *             ファイル入出力に関するエラーが発生した場合
     */
    @Test
    public void testCreateFile05() throws Exception {
	testObject.createFile("different.txt", "bbbbbbb");
	assertFile("output/exercise/sample.txt", "Sample Text");
	assertFile("output/exercise/sample_1.txt", "Sample Text2");
	assertFile("output/exercise/sample_2.txt", "Sample Text3");
	assertFile("output/exercise/different.txt", "aaaaaaa");
	assertFile("output/exercise/different_1.txt", "bbbbbbb");
    }
}
