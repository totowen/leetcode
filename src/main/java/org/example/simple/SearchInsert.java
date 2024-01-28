package org.example.simple;


/**
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 *
 * 解题思路：双指针，一个左指针，一个右指针，左指针指向比目标数小的值，右指针指向比目标数大的值，插入位置为右指针的位置，遍历数组，
 *
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6},2));;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = 0;
        for (int i=0;i< nums.length;i++){
            if(nums[i]==target){
                return i;
            }
            if(nums[i]<target){
                left = i;
                continue;
            }
            if(nums[i]>target){
                right = i;
                if(right==0){
                    return right;
                }else{
                    return i;
                }
            }

        }

        return left+1;
    }

}
