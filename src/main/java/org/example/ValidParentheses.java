package org.example;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 解题：屎一样的题解。。。总之用栈去存左括号，然后跟后面的右括号进行抵消操作，最后判断栈是否为空。
 */
public class ValidParentheses {

    public static void main(String[] args) {

        boolean valid = new ValidParentheses().isValid("([)]");
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        String[] split = s.split("");
        if(split.length % 2!=0){
            return false;
        }


        Deque<String> stack = new LinkedList<String>();
        for (int i = 0; i < split.length; i++) {

            if(map.containsKey(split[i])){
                stack.push(split[i]);
            }
            if(map.containsValue(split[i])){
                if(stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();
                if(!map.get(pop).equals(split[i])){
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }

}
