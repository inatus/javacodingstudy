package in.inagaki.javacodingstudy.example.chapter1;

public class Ex01ConnectingStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Profile profile = new Profile("inatus", 27, "Kawasaki");

	// だめな例：+で文字列を結合
	String message1 = "I'm " + profile.getName() + ", " + profile.getAge()
		+ " years old, living in " + profile.getCity() + ".";
	System.out.println(message1);

	// よい例：StringBuilder#appendメソッドで結合
	StringBuilder message2 = new StringBuilder();
	message2.append("I'm ");
	message2.append(profile.getName());
	message2.append(", ");
	message2.append(profile.getAge());
	message2.append(" years old, living in ");
	message2.append(profile.getCity());
	message2.append(".");
	String output = message2.toString();
	System.out.println(output);
    }

    static class Profile {
	private String name;
	private int age;
	private String city;

	public Profile(String name, int age, String city) {
	    super();
	    this.name = name;
	    this.age = age;
	    this.city = city;
	}

	public String getName() {
	    return name;
	}

	public int getAge() {
	    return age;
	}

	public String getCity() {
	    return city;
	}

    }

}
