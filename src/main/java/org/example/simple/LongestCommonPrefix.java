package org.example.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }

        String result = strs[0];

        for (int i = 0; i < strs.length ; i++) {
            while (strs[i].indexOf(result)!=0){
                result = result.substring(0,result.length()-1);
                if(result.isEmpty()){
                    return result;
                }
            }
        }

        return result;
    }

}
