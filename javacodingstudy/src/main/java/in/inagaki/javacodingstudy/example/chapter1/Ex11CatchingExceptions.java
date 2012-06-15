package in.inagaki.javacodingstudy.example.chapter1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex11CatchingExceptions {
    final String text = "Sample text";

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	Ex11CatchingExceptions obj = new Ex11CatchingExceptions();

	obj.execute1("output/outputNotExist.txt");
	System.out.println("execute1メソッド実行完了");
	obj.execute2("output/outputNotExist.txt");
	System.out.println("execute2メソッド実行完了");
	obj.execute3("output/outputNotExist.txt");
	System.out.println("execute3メソッド実行完了");
	System.out.println("処理終了");
    }

    // だめな例1：例外をどこでもキャッチしない
    public void execute3(String path) throws Exception {
	BufferedReader input = null;
	input = new BufferedReader(new FileReader(path));
	String line;
	while ((line = input.readLine()) != null) {
	    System.out.println(line);
	}
	if (input != null) {
	    input.close();
	}
    }

    // だめな例2：Exceptionをキャッチ、なにも処理しない
    public void execute2(String path) {
	BufferedReader input = null;
	try {
	    input = new BufferedReader(new FileReader(path));
	    String line;
	    while ((line = input.readLine()) != null) {
		System.out.println(line);
	    }
	} catch (Exception e) {
	    // なにもしない
	} finally {
	    if (input != null) {
		try {
		    input.close();
		} catch (Exception e) {
		    // なにもしない
		}
	    }
	}
    }

    // よい例：例外を具体的な型でキャッチし適切に処理する
    public void execute1(String path) {
	BufferedReader input = null;
	try {
	    input = new BufferedReader(new FileReader(path));
	    String line;
	    while ((line = input.readLine()) != null) {
		System.out.println(line);
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.err.println("execute1メソッドで例外が発生：" + path + "が見つかりません");
	} catch (IOException e) {
	    e.printStackTrace();
	    System.err.println("execute1メソッドで例外が発生：" + path + "の読み込みに失敗しました");
	} finally {
	    if (input != null) {
		try {
		    input.close();
		} catch (IOException e) {
		    e.printStackTrace();
		    System.err.println("execute1メソッドで例外が発生：" + path
			    + "の読み込みに失敗しました");
		}
	    }
	}
    }

}
