package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 移除元素
 * @author: Jiaty
 * @create: 2020-07-29 11:05
 **/

public class Solution27 {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     *
     * 注意这五个元素可为任意顺序。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *  
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     */


    /**
     * 误入歧途
     *
     *            ❌❌❌
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int i = 0;
        boolean flg = false;
        for (int j = 1; i < nums.length; j++) {
            int num = 0;
            if (j >= nums.length - 1) {
                num = 0;
            } else {
                num = nums[j];
            }
            if (nums[i] != val && !flg) {
                i++;
            } else if (nums[i] != val && flg) {
                i++;
                nums[i] = num;
            } else if (nums[i] == val && !flg) {
                if (num != val) {
                    nums[i] = num;
                    length = length - 1;
                    flg = true;
                    i++;
                }
            } else if (flg && nums[i] == val) {
                if (num != val) {
                    nums[i] = num;
                    length = length - 1;
                    i++;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int i1 = removeElement2(nums, val);
        System.out.println(i1);
        for (int i = 0; i < i1; i++) {
            System.out.print(nums[i]);
        }

    }


    /**
     * 正确解法1     拷贝覆盖
     *
     * 用双指针法，大概的思路就是
     * 把nums当成一个另一个数组，对这个数组里面的值进行遍历，遍历的指针是i
     * 同时另一个指针j。
     * 当num[i] 不等于 val 的时候，这个时候就把nums[i] 放进 nums[j]。哪怕 i= j
     * 这样就相当于对数组中的这个元素做了一次遍历
     *
     * 官方思路：主要思路是遍历数组nums，每次取出的数字变量为num，同时设置一个下标ans
     * 在遍历过程中如果出现数字与需要移除的值不相同时，则进行拷贝覆盖nums[ans] = num，ans自增1
     * 如果相同的时候，则跳过该数字不进行拷贝覆盖，最后ans即为新的数组长度
     * 这种思路在移除元素较多时更适合使用，最极端的情况是全部元素都需要移除，遍历一遍结束即可
     * 时间复杂度：O(n)，空间复杂度：O(1)
     *
     */
    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    /**
     * 官方解法：
     *
     * 现在考虑数组包含很少的要删除的元素的情况。例如，num=[1，2，3，5，4]，Val=4。之前的算法会对前四个元素做不必要的复制操作。另一个例子是 num=[4，1，2，3，5]，Val=4。似乎没有必要将 [1，2，3，5][1，2，3，5] 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
     *
     * 当我们遇到 nums[i] == val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
     *
     * 请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
     *
     *   复杂度分析
     *
     * 时间复杂度：O(n)，i 和 n 最多遍历 n 步。在这个方法中，赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率会更高。
     *
     * 空间复杂度：O(1)。
     *
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}