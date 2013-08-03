package in.inagaki.javacodingstudy.example.chapter1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ex10ClosingStreams {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String text = "Sample text";
	File directory = new File("output/example");
	directory.mkdirs();

	// だめな例：ストリームをクローズしない
	BufferedWriter output1 = null;
	try {
	    output1 = new BufferedWriter(new FileWriter(
		    "output/example/output5.txt"));
	    output1.write(text);
	    output1.flush();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	// よい例：ストリームをクローズする
	BufferedWriter output2 = null;
	try {
	    output2 = new BufferedWriter(new FileWriter(
		    "output/example/output5.txt"));
	    output2.write(text);
	    output2.flush();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (output2 != null) {
		    output2.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	// よい例：Java 7のtry-with-resources文を用いる
	try (BufferedWriter output3 = new BufferedWriter(new FileWriter(
		"output/example/output5.txt"))) {
	    output3.write(text);
	    output3.flush();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
