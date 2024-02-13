package org.example.study;

import java.util.Arrays;

/**
 * 寻找数组中心索引
 * 解题；
 * 合计数组元素sum
 * 遍历元素，判断总数减去当前元素和左边元素之和，是否等于左边元素之和。
 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {

        int length = nums.length;
        int sum = Arrays.stream(nums).sum();

        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (sum - nums[i]-temp == temp) {
                return i;
            }
            temp += nums[i];
        }
        return -1;
    }

}
