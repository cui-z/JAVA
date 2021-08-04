package Day15;
/*
需求： 计算一个字符串中每个字符出现次数。
分析：1. 获取一个字符串对象
2. 创建一个Map集合，键代表字符，值代表次数。
3. 遍历字符串得到每个字符。
4. 判断Map中是否有该键。
5. 如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。 6. 打印最终结果
 */

import Day10.C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapPractice_ {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner sc = new Scanner(System.in);
        String line  = sc.nextLine();
        get_num(line);
    }
    public static void get_num(String str){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0;i <str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int v = map.get(c);
                map.put(c,v+1);

            }else {
                map.put(c,1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry);
        }

    }
}
