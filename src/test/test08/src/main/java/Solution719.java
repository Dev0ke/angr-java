import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution719 {
    // 暴力解法 O(n^2)
    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    // 二分 O(nlogn)
    public int smallestDistancePair2(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 距离为 mid 是否为第 k 小，FFFTTT
    private boolean checkMid(int[] nums, int k, int mid) {
        int cnt = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] - nums[i] > mid) {
                i++;
            }
            cnt += j - i;
        }
        return cnt >= k;
    }
}
/*
719. 找出第 K 小的数对距离
https://leetcode.cn/problems/find-k-th-smallest-pair-distance/

数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
提示：
n == nums.length
2 <= n <= 10^4
0 <= nums[i] <= 10^6
1 <= k <= n * (n - 1) / 2

暴力解法 MLE
二分。
 */