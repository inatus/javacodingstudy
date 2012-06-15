package in.inagaki.javacodingstudy.example.chapter1;

public class Ex01ConnectingStrings {

    // だめな例：+=で文字列を結合
    public String connectSentence1(String[] wordArray) {
	String sentence = "";
	for (String word : wordArray) {
	    sentence += word + " ";
	}
	return sentence.trim();
    }

    // よい例：StringBuilder#appendメソッドで結合
    public String connectSentence2(String[] wordArray) {
	StringBuilder sentence = new StringBuilder();
	for (String word : wordArray) {
	    sentence.append(word);
	    sentence.append(" ");
	}
	return sentence.toString().trim();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Ex01ConnectingStrings obj = new Ex01ConnectingStrings();
	String[] wordArray = { "I'm", "inatus,", "27", "years", "old,",
		"living", "in", "Kawasaki." };

	System.out.println(obj.connectSentence1(wordArray));
	System.out.println(obj.connectSentence2(wordArray));
    }

}
