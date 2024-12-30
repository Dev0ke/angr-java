import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2164 {
    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                oddList.add(nums[i]);
            } else {
                evenList.add(nums[i]);
            }
        }

        // 按 非递增 顺序排列 nums 奇数下标 上的所有值。
        Collections.sort(oddList, Comparator.reverseOrder());
        // 按 非递减 顺序排列 nums 偶数下标 上的所有值。
        Collections.sort(evenList);

        int idx = 0;
        List<Integer> resList = new ArrayList<>();
        while (idx < oddList.size()) {
            resList.add(evenList.get(idx));
            resList.add(oddList.get(idx));
            idx++;
        }
        while (idx < evenList.size()) {
            resList.add(evenList.get(idx));
            idx++;
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
2164. 对奇偶下标分别排序
https://leetcode.cn/problems/sort-even-and-odd-indices-independently/

第 279 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
1.按 非递增 顺序排列 nums 奇数下标 上的所有值。
  - 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
2.按 非递减 顺序排列 nums 偶数下标 上的所有值。
  - 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。
返回重排 nums 的值之后形成的数组。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

注意到数据量很小，直接暴力模拟。
 */
