package org.example;

public class test {


    public static void main(String[] args) {
        /**
         * 给定一个非空的字符串s，检查是否可以通过由它的一个子串重复多次构成。
         * 例：
         * 输入：s="abab"
         * 输出：true
         * 解释：可由子串"ab”重复两次构成。
         * 输入：s="abc”
         * 输出：false
         * 解释：无法通过子串重复多次构成。
         */
        String s = "abcabc";
        boolean result = repeatedSubstringPattern(s);
        System.out.println(result);

    }

    private static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if(length % 2!=0){
            return false;
        }
        for (int i = 1; i < length/2; i++) {
            String substring = s.substring(0, i);
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < length/i; j++) {
                stringBuilder.append(substring);
            }

            if(stringBuilder.toString().equals(s)){
                return true;
            }
        }


        return true;
    }

}
