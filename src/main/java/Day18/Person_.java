package Day18;

import java.util.Objects;

public class Person_ {
    private String name;
    private int age;

    public Person_(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_ person_ = (Person_) o;
        return age == person_.age &&
                Objects.equals(name, person_.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person_{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}
