package org.example.simple;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * 题解：
 * 使用双指针，一个指向nums1的数组下标，另一个指向nums2的数组下标。因为是逐位遍历，所以可以在一个while循环中进行。
 * 循环的条件为各自指针不超过各个数组的长度。当nums1的p1位大于nums2的p2位时，将nums2的p2位的值赋值给新数组，赋值的同时，将指针++操作。
 * 注意两个数组的边界，当一个数组的指针等于数组长度时，当前指针的值需要指向另一个数组的指针位上的值，并且另一个数组的指针位需要一直++直到赋值完成。
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[]{2, 3, 4, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur = 0;
        while(p1<m || p2<n){
            if(p1==m){ //相当于nums1的数组已经遍历完了
                cur = nums2[p2++];
            } else if (p2==n) { //相当于nums2的数组遍历完了
                cur = nums1[p1++];
            }else if(nums1[p1]>=nums2[p2]){ //数组1的值大于数组2的值时，数组2的当前位的值进入新的排序数组
                cur = nums2[p2++];
            } else if(nums1[p1]<nums2[p2]){
                cur = nums1[p1++];
            }

            sorted[p1+p2-1] = cur;

        }

        //遍历赋值给nums1
        for (int i = 0; i < m+n; i++) {

            nums1[i] = sorted[i];

        }

        System.out.println(nums1);

    }

}
