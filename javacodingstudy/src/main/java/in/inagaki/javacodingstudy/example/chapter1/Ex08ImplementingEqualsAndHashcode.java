package in.inagaki.javacodingstudy.example.chapter1;

import java.util.HashSet;
import java.util.Set;

public class Ex08ImplementingEqualsAndHashcode {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Set<Profile1> profileHashSet1 = new HashSet<Profile1>();
	Profile1 profile1 = new Profile1("inatus", 27, "Kawasaki");
	profileHashSet1.add(profile1);
	Profile1 profile2 = new Profile1("inatus", 27, "Kawasaki");
	profileHashSet1.add(profile2);
	System.out.println(profileHashSet1.size());

	Set<Profile2> profileHashSet2 = new HashSet<Profile2>();
	Profile2 profile3 = new Profile2("inatus", 27, "Kawasaki");
	profileHashSet2.add(profile3);
	Profile2 profile4 = new Profile2("inatus", 27, "Kawasaki");
	profileHashSet2.add(profile4);
	System.out.println(profileHashSet2.size());
    }

}

// ダメな例：equals()、hashcode()メソッドを実装しない
class Profile1 {
    private String name;
    private int age;
    private String city;

    public Profile1(String name, int age, String city) {
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

// よい例：equals()、hashcode()メソッドを実装
class Profile2 {
    private String name;
    private int age;
    private String city;

    /*
     * (非 Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    /*
     * (非 Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof Profile2)) {
	    return false;
	}
	Profile2 other = (Profile2) obj;
	if (age != other.age) {
	    return false;
	}
	if (city == null) {
	    if (other.city != null) {
		return false;
	    }
	} else if (!city.equals(other.city)) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	return true;
    }

    public Profile2(String name, int age, String city) {
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