package uebungen_2;

public class Person {
    private String firstname;
    private String lastname;
    private int year;
    private int age;

    public Person(String firstname, String lastname, int year) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.year = year;
    }

    /**
     * convenience constructor with an sequence of Strings
     * @param names
     */
    public Person(String... names) {
        this.firstname = names[1];
        this.lastname = names[0];
        this.year = Integer.parseInt(names[2]);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", year=" + year +
                ", age=" + age +
                '}';
    }
}
