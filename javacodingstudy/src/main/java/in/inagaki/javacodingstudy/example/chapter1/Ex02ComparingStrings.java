package in.inagaki.javacodingstudy.example.chapter1;

public class Ex02ComparingStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// だめな例：文字列を==で比較
	String str1 = "123";
	if (str1 == "123") {
	    System.out.println("だめな例: true");
	} else {
	    System.out.println("だめな例: false");
	}

	// よい例：文字列をequalsメソッドで比較
	String str2 = "123";
	if ("123".equals(str2)) {
	    System.out.println("よい例: true");
	} else {
	    System.out.println("よい例: false");
	}

	// 問題となるだめな例
	StringBuilder str3 = new StringBuilder("123");
	String str4 = str3.toString();
	if (str4 == "123") {
	    System.out.println("問題となるだめな例: true");
	} else {
	    System.out.println("問題となるだめな例: false");
	}

	// 問題とならないよい例
	StringBuilder str5 = new StringBuilder("123");
	String str6 = str5.toString();
	if ("123".equals(str6)) {
	    System.out.println("問題とならないよい例: true");
	} else {
	    System.out.println("問題とならないよい例: false");
	}
    }
}
