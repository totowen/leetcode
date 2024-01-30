package org.example.simple;


/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 解题：
 * 1.将int数组转成字符串，然后转int+1,然后转String数组，最后转int数组（不行，中间过程会超过整数类型的长度范围）
 * 2.从数组末尾开始做加1处理，如果不需要进一位就直接加一处理，如果需要进一位，查看是不是最高位进一，不是最高位进一就记录索引的下一位加一就行，
 *      如果是最高位进一还得增加原数组的长度+1然后对数组重新赋值
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(plusOne.plusOne(new int[]{9,9,9,9,9}));;
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        //标记是否需要加一的索引位
        int temp = length-1;

        for (int i = temp; i >=0; i--) {
            Integer digit = digits[i]+1;
            if(digit>9){
                if(i==0){
                    int[] ints = new int[length + 1];
                    for (int j = 0; j < length; j++) {
                        ints[i+1] = digits[i];
                    }
                    ints[1] = 0;
                    ints[0] = 1;
                    return ints;
                }
                temp --;
                digits[i] = 0;
            }else{
                digits[i] = digit;
            }
            if(temp == i){
                break;
            }

        }

        return digits;
    }

}
