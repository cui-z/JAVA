package Day15;

import java.util.LinkedHashMap;
import java.util.Map;

/*
我们知道HashMap保证成对元素唯一，并且查询速度很快，可是成对元素存放进去
  是没有顺序的，那么我们要保 证有序，还要速度快怎么办呢？
     在HashMap下面有一个子类LinkedHashMap，它是链表和哈希表组合的一个
     数据存储结构。
 */
public class LinkedHashMap_ {
    public static void main(String[] args) {
        LinkedHashMap<String,String> lk = new LinkedHashMap<>();
        lk.put("cc","cc");
        lk.put("aa","aa");
        lk.put("bb","bb");
        for (Map.Entry<String, String> stringStringEntry : lk.entrySet()) {
            System.out.println(stringStringEntry.getKey()+"  "+stringStringEntry.getValue());
        }
    }

}
