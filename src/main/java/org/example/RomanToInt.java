package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        int result = romanToInt.romanToInt("MCMXCIV");
        System.out.println(result);
    }

    /**
     * 左边的数大于右边，如果出现右边的数小于左边，则为组合数，需要进行右边数减左边数
     * 左边数等于右边，继续遍历右边的数，直到出现不想等位置，不想等的值不参与相加操作
     * 左边的数小于右边，直接相加
     *
     * @param s
     * @return
     */
    Map<String, Integer> map = new HashMap();

    static {
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {


        //拆分s的罗马数值为字符串数组
        String[] split = s.split("");
        //定义一个变量，用来存储最终的结果
        int result = 0;

        //遍历字符串数组
        for (int i = 0; i < split.length; i++) {
            //如果当前的数值小于下一个数值，说明是组合数
            if (i < split.length - 1 && map.get(split[i]) < map.get(split[i + 1])) {
                //将下一个数值减去当前的数值，得到组合数的值
                result += map.get(split[i + 1]) - map.get(split[i]);
                //因为已经计算了下一个数值，所以跳过下一个数值
                i++;
            } else {
                //如果当前的数值大于等于下一个数值，说明不是组合数，直接相加
                result += map.get(split[i]);
            }
        }


        return result;
    }
}
