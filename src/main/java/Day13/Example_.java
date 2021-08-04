package Day13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
按照斗地主的规则，完成洗牌发牌的动作。
具体规则：

使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。

## 4.2 案例分析

* 准备牌：

  牌可以设计为一个ArrayList<String>,每个字符串为一张牌。
  每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
  牌由Collections类的shuffle方法进行随机排序。

* 发牌

  将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。


* 看牌

  直接打印每个集合。
 */
public class Example_ {
    public static void main(String[] args) {
        //创建牌盒
        ArrayList<String> ph = new ArrayList<String>();
        //创建花色
        ArrayList<String> hs = new ArrayList<String>();
        //创建数字集合
        ArrayList<String> sz = new ArrayList<String>();
        //天加
        hs.add("♥");
        hs.add("♦");
        hs.add("♣");
        hs.add("♠");
        for(int i=2 ;i<=10;i++){
            sz.add(i+"");
        }
        sz.add("J");
        sz.add("Q");
        sz.add("K");
        sz.add("A");
        for (String h : hs) {
            for (String s : sz) {
                ph.add(h+s);
            }
        }
        ph.add("大王");
        ph.add("小王");

        Collections.shuffle(ph);
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> dipai = new ArrayList<String>();

        for(int i =0;i< ph.size();i++){
            String card = ph.get(i);
            if (i >= 51) {
                dipai.add(card);
            }else {
                if(i % 3 == 0){
                    player1.add(card);
                }else if(i % 3 == 1){
                    player2.add(card);
                }else {
                    player3.add(card);
                }

            }
        }
        System.out.println("玩家1"+player1);
        System.out.println("玩家2"+player2);
        System.out.println("玩家三"+player3);
        System.out.println("底牌"+dipai);
    }
}
