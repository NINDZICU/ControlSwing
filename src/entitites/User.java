package entitites;

/**
 * Created by Admin on 25.11.2016.
 */
public class User {
    private int id;
    private String name;
    private String family;
    private int age;
    private boolean gender;

    public User(int id, String name, String family, int age, boolean gender) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }
}
