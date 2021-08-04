package Day24;

public class Persion_ {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Persion_{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persion_(String name) {
        this.name = name;
    }
}
