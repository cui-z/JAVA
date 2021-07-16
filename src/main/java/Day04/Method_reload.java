package Day04;

/*
方法重载 意思是同一个类中，允许存在一个以上的同名方法，只需要参数列表不同即可
         与修饰符和返回值类型无关

参数列表不同是指  个数不同，数据类型不同，顺序不同


 */
public class Method_reload {

    public static void main(String[] args) {
        int a = 1;
        int b =1;
        byte c = 3;
        byte d =3;
        System.out.println(compare(a,b));
        System.out.println(compare(c,d));


    }

    //判断两个数是否相同

    public static boolean compare(int a ,int b){
        return a == b;
    }
    public static boolean compare(byte a ,byte b){
        return a == b;
    }
}
