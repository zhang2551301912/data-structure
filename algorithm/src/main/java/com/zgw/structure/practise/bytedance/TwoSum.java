package zgw.practise.bytedance;

import java.util.HashMap;

/**
 * @Description
 * @Author zgw
 * @email 2551301912@qq.com
 * @Date 2022--05--10 11:16
 */
public class TwoSum {
    /*
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    *
    * 示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    * 示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]

    *
    * 示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]
    * */
    public static int[] twoSum(int[] nums, int target) {
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        int[] index = new int[2];
        //方式一:建立k-v ，一一对应的哈希表-效率高-1ms
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                index[0] = i;
                index[1] = hash.get(nums[i]);
                return index;
            }
            //将数据存入 key为补数 ，value为下标
            hash.put(nums[i], i);
        }

        //方式二:双重循环 循环极限为(n^2-n)/2--速度较慢-50ms
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }
}
