package in.inagaki.javacodingstudy.example.chapter1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Ex09UsingProperStreams {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String text = "Sample text";
	File directory = new File("output/example");
	directory.mkdirs();

	// だめな例1：1バイトずつ読み書きする
	// バイトストリーム書き込み
	OutputStream output1 = null;
	try {
	    output1 = new FileOutputStream("output/example/output1.txt");
	    output1.write(text.getBytes());
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (output1 != null) {
		    output1.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	// バイトストリーム読み込み
	InputStream input1 = null;
	try {
	    input1 = new FileInputStream("output/example/output1.txt");
	    byte[] buf = new byte[4096];
	    int len;
	    while ((len = input1.read(buf)) != -1) {
		System.out.write(buf, 0, len);
	    }
	    System.out.println();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (input1 != null) {
		try {
		    input1.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}

	// よい例1：バッファを利用して数バイトずつ読み書きする
	// バイトストリーム書き込み
	BufferedOutputStream output2 = null;
	try {
	    output2 = new BufferedOutputStream(new FileOutputStream(
		    "output/example/output2.txt"));
	    output2.write(text.getBytes());
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
	// バイトストリーム読み込み
	BufferedInputStream input2 = null;
	try {
	    input2 = new BufferedInputStream(new FileInputStream(
		    "output/example/output2.txt"));
	    byte[] buf = new byte[4096];
	    int len;
	    while ((len = input2.read(buf)) != -1) {
		System.out.write(buf, 0, len);
	    }
	    System.out.println();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (input2 != null) {
		try {
		    input2.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}

	// だめな例2：1文字ずつ読み書きする
	// 文字ストリーム書き込み
	Writer output3 = null;
	try {
	    output3 = new FileWriter("output/example/output3.txt");
	    output3.write(text);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (output3 != null) {
		    output3.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	// 文字ストリーム読み込み
	Reader input3 = null;
	try {
	    input3 = new FileReader("output/example/output3.txt");
	    char[] cbuf = new char[4096];
	    int len;
	    while ((len = input3.read(cbuf)) != -1) {
		System.out.write(String.valueOf(cbuf).getBytes(), 0, len);
	    }
	    System.out.println();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (input3 != null) {
		try {
		    input3.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}

	// よい例2：バッファを利用して数文字ずつ読み書きする
	// 文字ストリーム書き込み
	BufferedWriter output4 = null;
	try {
	    output4 = new BufferedWriter(new FileWriter(
		    "output/example/output4.txt"));
	    output4.write(text);
	    output4.flush();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (output4 != null) {
		    output4.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	// 文字ストリーム読み込み
	BufferedReader input4 = null;
	try {
	    input4 = new BufferedReader(new FileReader(
		    "output/example/output4.txt"));
	    String line;
	    while ((line = input4.readLine()) != null) {
		System.out.println(line);
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (input4 != null) {
		try {
		    input4.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	}

    }

}
