package Day06;

public class Test_Phone {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.band = "小米";
        p.price = 1999;
        p.color = "黑色";
        System.out.println(p.band);
        System.out.println(p.price);
        System.out.println(p.color);
        System.out.println("--------");
        p.call("leijun");
        p.sendMessage();

    }
}
