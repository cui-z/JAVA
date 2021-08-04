package Day10;

public class C implements A,B {
    @Override
    public void showA() {
        System.out.println("show a");
    }

    @Override
    public void show() {
        System.out.println("show  --");

    }

    @Override
    public void showB() {
        System.out.println("showb ===");

    }
}
