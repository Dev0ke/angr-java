import java.util.ArrayList;
import java.util.List;

public class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int min = Math.abs(nums[0]);
        List<Integer> minList = new ArrayList<>();

        for (int num : nums) {
            if (Math.abs(num) < min) {
                min = Math.abs(num);
                minList.clear();
                minList.add(num);
            } else if (Math.abs(num) == min) {
                minList.add(num);
            }
        }

        // 如果有多个答案，请你返回它们中的 最大值 。
        int max = minList.get(0);
        for (int num : minList) {
            max = Math.max(max, num);
        }
        return max;
    }
}
/*
2239. 找到最接近 0 的数字
https://leetcode.cn/problems/find-closest-number-to-zero/

第 76 场双周赛 T1。

给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
提示：
1 <= n <= 1000
-10^5 <= nums[i] <= 10^5

模拟
时间复杂度 O(n)
 */