package in.inagaki.javacodingstudy.example.chapter1;

public class Ex05PrimitiveAndReference {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Ex05PrimitiveAndReference obj = new Ex05PrimitiveAndReference();

	// プリミティブ型を引数としたメソッド呼び出しの例
	int var1 = 1;
	obj.execute(var1);
	System.out.println(var1);

	// 参照型を引数としたメソッド呼び出しの例
	int[] var2 = { 1 };
	obj.execute(var2);
	System.out.println(var2[0]);
    }

    public void execute(int par1) {
	par1++;
    }

    public void execute(int[] par2) {
	par2[0]++;
    }
}
