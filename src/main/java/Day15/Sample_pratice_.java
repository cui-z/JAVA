package Day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/*
模拟斗地主洗牌发牌
    案例介绍
        按照斗地主的规则，完成洗牌发牌的动作。
    具体规则：
        1. 组装54张扑克牌将
        2. 54张牌顺序打乱
        3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，
            最后三张留作底牌。
        4. 查看三人各自手中的牌（按照牌的大小排序）、底牌
 规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
public class Sample_pratice_ {
    public static void main(String[] args) {
        /*
1. 准备牌： 完成数字与纸牌的映射关系： 使用双列Map(HashMap)集合，完成一个数字与字符串纸牌
    的对应关系(相当于一个字典)。
2. 洗牌： 通过数字完成洗牌发牌
3. 发牌： 将每个人以及底牌设计为ArrayList,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次
   发牌。 存放的过程中要求数字大小与斗地主规则的大小对应。 将代表不同纸牌的数字分配给不同的
   玩家与底牌。
4. 看牌： 通过Map集合找到对应字符展示。 通过查询纸牌与数字的对应关系，由数字转成纸牌字符串再
   进行展示
         */

        HashMap<Integer,String> pk = new HashMap<>();
        ArrayList<String> color =  new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        Collections.addAll(color,"♦","♣","♠","♥");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        int count = 1;
        pk.put(count++,"大王");
        pk.put(count++,"小王");
        for (String number : numbers) {
            for (String s : color) {
                pk.put(count++,s+number);
            }
        }
        System.out.println(pk);
        //编号取出
        Set<Integer> numset = pk.keySet();
        ArrayList<Integer> numlist =new ArrayList<>();
        numlist.addAll(numset);
        Collections.shuffle(numlist);

        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> p3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for(int i = 0; i< numlist.size();i++){
            Integer index = numlist.get(i);
            if( i>= 51){
                dipai.add(index);
            }else {
                if (i %3 ==0){
                    p1.add(index);
                }else if(i %3 ==1){
                    p2.add(index);
                }else {
                    p3.add(index);
                }
            }
        }
        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(dipai);

        ArrayList<String> newp1 = new ArrayList<>();
        ArrayList<String> newp2 = new ArrayList<>();
        ArrayList<String> newp3 = new ArrayList<>();
        ArrayList<String> newdipai = new ArrayList<>();
        get_string(p1,newp1,pk);
        get_string(p2,newp2,pk);
        get_string(p3,newp3,pk);
        get_string(dipai,newdipai,pk);
        System.out.println("牌友1"+newp1);
        System.out.println("牌友2"+newp2);
        System.out.println("牌友3"+newp3);
        System.out.println("底牌"+newdipai);



    }

    public static void get_string(ArrayList<Integer> arr1 , ArrayList<String> arr2,HashMap<Integer,String> arr3){
        for (Integer integer : arr1) {
            arr2.add(arr3.get(integer));

        }

    }
}
