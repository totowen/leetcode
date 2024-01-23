package org.example;


import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 例如，121 是回文，而 123 不是。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * <p>
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * -231 <= x <= 231 - 1
     * <p>
     * <p>
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     * <p>
     * 解题思路：
     * 1.负数不是回文数
     * 2.如果是回文数，反转后的数和原数相等
     * 3.反转后的数可能会溢出，所以反转一半的数就可以了
     * 4.如果是奇数，反转后的数比原数多一位，所以反转后的数除以10，和原数相等就可以了
     * 5.如果是偶数，反转后的数和原数相等就可以了
     * 6.如果是0，就是回文数
     * 7.如果是10的倍数，不是回文数
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int y = 0;
        while (temp != 0) {
            y = y * 10 + temp % 10;  //  1  12  121
            temp /= 10;              //  12  1   0
        }
        return x == y;
    }

    /**
     * 左边的数大于右边，如果出现右边的数小于左边，则为组合数，需要进行右边数减左边数
     * 左边数等于右边，继续遍历右边的数，直到出现不想等位置，不想等的值不参与相加操作
     * 左边的数小于右边，直接相加
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

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

        public static void main (String[]args){

            Solution solution = new Solution();
//        boolean palindrome = solution.isPalindrome(121);
//        boolean palindrome = solution.isPalindrome(123);
//        boolean palindrome = solution.isPalindrome(-121);
//        System.out.println(palindrome);
        }
    }