package Day09;

import java.util.ArrayList;

public class Qun_zhu extends User {
    public Qun_zhu(){};
    public Qun_zhu(String username , double leftmoney){
        super(username,leftmoney);
    }

    public ArrayList<Double> send (int money , int count){

        double leftmoney = getLeftMoney();
        if (money > leftmoney){
            return null;
        }
        setLeftMoney(leftmoney - money);

        ArrayList<Double>  arr = new ArrayList<Double>();
        money = money *100; //避免精度损失
        int m = money / count;
        int l  = money % count;

        for (int i = 0;i < count-1;i++){
            arr.add(m / 100.0);
        }
        if (l == 0){
            arr.add(m/100.0);
        } else {
            arr.add((m+l)/100.0);
        }
        return  arr;
    }
}
