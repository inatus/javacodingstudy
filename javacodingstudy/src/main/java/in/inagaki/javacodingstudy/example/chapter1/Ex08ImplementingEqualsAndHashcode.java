package in.inagaki.javacodingstudy.example.chapter1;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

// よい例：equals()、hashcode()メソッドを実装しない
class Profile2 {
    private String name;
    private int age;
    private String city;

    @Override
    public boolean equals(Object paramObject) {
	if (paramObject == null) {
	    return false;
	}
	if (paramObject == this) {
	    return true;
	}
	if (!(paramObject instanceof Profile2)) {
	    return false;
	}
	Profile2 target = (Profile2) paramObject;
	return new EqualsBuilder().append(name, target.name)
		.append(age, target.age).append(city, target.city).isEquals();
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(name).append(age).append(city)
		.hashCode();
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