package Day08;

public class Student {
    private String name;
    private int age;
    private int sid; //编号id
    public static int number = 0 ;//类变量  记录数量

    //在构造方法里面进行自动加减 因为每一次new调用   所以用一个来存储  每个对象都共享
    public Student(String name , int age){
        this.name = name;
        this.age = age;
        this.sid = ++number;
        //  ++i  是i先＋1  然后再参与运损
        // i++ 是先参与运算 然后再+1
    }

    public void show(){
        System.out.println("name id "+ this.name +",age is "+this.age+", sid is "+this.sid);
    }

    public static void shownum(){
        System.out.println("num is "+number);
    }
}
