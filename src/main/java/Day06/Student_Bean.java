package Day06;

public class Student_Bean {
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String name ;
    private int age;

    public Student_Bean(){}

    public  Student_Bean(String name,int age){
        this.name = name;
        this.age = age;
    }

}
