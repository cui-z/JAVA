package Day12;

import java.util.Objects;

public class Persion {
    private String name;
    private int age;
    public Persion(String name ,int ange){
        this.name = name;
        this.age = ange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persion persion = (Persion) o;
        return age == persion.age &&
                Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
