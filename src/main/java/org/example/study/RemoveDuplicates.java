package org.example.study;

/**
 * 删除排序数组中的重复项
 *
 * 一个有序数组 nums ，原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长
 * 度。
 * 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 解题：
 *
 *注意是有序数组，双指针算法，当nums[i]==nums[j]的时候跳过，nums[i]!=nums[j]时，将nums[i+1]=nums[j]，并且i++.从夫上述过程。退出循环后，
 * 元素个数等于i+1,因为i是从0开始统计的。
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,2,3,3,4,4,4,4,5,5,5,5,5}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[i]==nums[j]){
                continue;
            }
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;



    }

}
