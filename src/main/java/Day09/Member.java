package Day09;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member(){};
    public Member(String username , double leftMoney){
        super(username,leftMoney);
    }

    public void openRed (ArrayList<Double> arr){
        Random r = new Random();
        int index = r.nextInt(arr.size());
        double money = arr.remove(index);
        setLeftMoney(money);

    }
}
