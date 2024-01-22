package org.example;


/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * 解题思路：
 * 1.负数不是回文数
 * 2.如果是回文数，反转后的数和原数相等
 * 3.反转后的数可能会溢出，所以反转一半的数就可以了
 * 4.如果是奇数，反转后的数比原数多一位，所以反转后的数除以10，和原数相等就可以了
 * 5.如果是偶数，反转后的数和原数相等就可以了
 * 6.如果是0，就是回文数
 * 7.如果是10的倍数，不是回文数
 */
class Solution {
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

    public static void main(String[] args) {

        Solution solution = new Solution();
//        boolean palindrome = solution.isPalindrome(121);
//        boolean palindrome = solution.isPalindrome(123);
//        boolean palindrome = solution.isPalindrome(-121);
//        System.out.println(palindrome);
    }
}