package in.inagaki.javacodingstudy.example.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex07UsingProperCollections {
    Map<Profile, Object> profileHashMap = new HashMap<Profile, Object>();
    Set<Profile> profileHashSet = new HashSet<Profile>();
    List<Profile> profileArrayList = new ArrayList<Profile>();
    Set<Profile> profileLinkedHashSet = new LinkedHashSet<Profile>();

    /**
     * @param args
     */
    public static void main(String[] args) {

	Ex07UsingProperCollections obj = new Ex07UsingProperCollections();
	Profile profile = new Profile("inatus", 27, "Kawasaki");

	obj.execute(profile);
	System.out.println(obj.profileHashMap);
	System.out.println(obj.profileHashSet);
	System.out.println(obj.profileArrayList);
	System.out.println(obj.profileLinkedHashSet);
    }

    private void execute(Profile profile) {
	// だめな例1：HashMapのキーに常にnullを挿入
	profileHashMap.put(profile, null);

	// よい例1：HashSetを使用
	profileHashSet.add(profile);

	// だめな例2：要素が重複しないようにArrayListに挿入
	if (!profileArrayList.contains(profile)) {
	    profileArrayList.add(profile);
	}

	// よい例2：LinkedHashSetを使用
	profileLinkedHashSet.add(profile);
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
