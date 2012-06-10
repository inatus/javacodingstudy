package in.inagaki.javacodingstudy.example.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Ex06AvoidingBoxing {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Ex06AvoidingBoxing obj = new Ex06AvoidingBoxing();
	List<Integer> integerList = new ArrayList<Integer>();
	integerList.add(1);

	obj.execute(integerList);
    }

    public void execute(List<Integer> integerList) {
	// だめな例
	Integer val1 = integerList.get(0);
	val1++;
	System.out.println(val1);

	// よい例
	int val2 = integerList.get(0);
	val2++;
	System.out.println(val2);

	// だめな例の実際の処理
	Integer val3 = integerList.get(0);
	int tmp = val3.intValue(); // アンボクシング
	tmp++;
	val3 = new Integer(tmp); // ボクシング
	System.out.println(val3);

	// よい例の実際の処理
	int val4 = integerList.get(0).intValue(); // アンボクシング
	val4++;
	System.out.println(val4);
    }

}