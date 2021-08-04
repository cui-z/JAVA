package Day10;

public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("鼠标 开");
    }

    @Override
    public void close() {
        System.out.println("鼠标 关");

    }


    public void click(){
        System.out.println("鼠标 点击");
    }
}
