package Day10;

public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("键盘 开 ");
    }

    @Override
    public void close() {
        System.out.println("键盘 关 ");

    }

    public void type(){
        System.out.println("键盘打字");
    }

}
