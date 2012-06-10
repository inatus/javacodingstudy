package in.inagaki.javacodingstudy.example.chapter1;

public class Ex04FloatingPointRange {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// おかしな例
	double num1 = 1.7976931348623155;
	System.out.println(num1);
	System.out.println(num1 + 0.0000000000000001); // 最後の桁に1を足す

    }
}
