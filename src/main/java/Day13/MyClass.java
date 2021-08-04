package Day13;

public class MyClass<MVP> {
    public void setMvp(MVP mvp) {
        this.mvp = mvp;
    }

    public MVP getMvp() {
        return mvp;
    }

    //没有MVP数据类型，代表未知的数据类型，未来传递什么就是什么类型
    private MVP mvp;

}
