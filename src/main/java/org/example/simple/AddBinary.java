package org.example.simple;

/**
 * 二进制求和
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * <p>
 * 题解：
 * 1.将二进制转为十进制计算后再转二进制 (不行，当String超长，超过类型的长度会报错)
 * 2.将两个二进制字符串反转顺序，然后逐个位置进行二进制计算，计算后将结果反转，注意需要标注进制的下标位，如果需要进一位，需要有标记
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary2("11", "1"));
    }

    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary2(String a, String b) {
        StringBuilder ar = new StringBuilder(a).reverse();
        StringBuilder br = new StringBuilder(b).reverse();
        StringBuilder cr = new StringBuilder();

        int alen = a.length();
        int blen = b.length();

        boolean index = false;
        if (alen < blen) {
            for (int i = 0; i < blen - alen; i++) {
                ar.append(0);
            }

            char[] acharArray = ar.toString().toCharArray();
            char[] bcharArray = br.toString().toCharArray();

            for (int i = 0; i < blen; i++) {
                int ai = acharArray[i]-'0';
                int bi = bcharArray[i]-'0';
                if (ai + bi > 1) {
                    if (index) {
                        cr.append(1);
                    } else {
                        cr.append(0);
                    }
                    index = true;
                }
                if (ai + bi == 1) {
                    if (index) {
                        cr.append(0);
                    } else {
                        cr.append(1);
                    }
                }
                if (ai + bi == 0) {
                    if (index) {
                        cr.append(1);
                        index = false;
                    } else {
                        cr.append(0);
                    }
                }
            }

        } else {
            for (int i = 0; i < alen - blen; i++) {
                br.append(0);
            }

            char[] acharArray = ar.toString().toCharArray();
            char[] bcharArray = br.toString().toCharArray();

            for (int i = 0; i < alen; i++) {
                int ai = acharArray[i]-'0';
                int bi = bcharArray[i]-'0';
                if (ai + bi > 1) {
                    if (index) {
                        cr.append(1);
                    } else {
                        cr.append(0);
                    }
                    index = true;
                }
                if (ai + bi == 1) {
                    if (index) {
                        cr.append(0);
                    } else {
                        cr.append(1);
                    }
                }
                if (ai + bi == 0) {
                    if (index) {
                        cr.append(1);
                        index = false;
                    } else {
                        cr.append(0);
                    }
                }
            }
        }
        if(index){
            return cr.append(1).reverse().toString();
        }else {
            return cr.reverse().toString();
        }

    }
}
