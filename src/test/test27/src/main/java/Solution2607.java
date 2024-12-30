import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;

        // a[i] = a[i + x * k] = a[i + x * k + y * n]
        // x * k + y * n = gcd(k, n)
        k = getGCD(k, n);

        Map<Integer, List<Integer>> modkMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int modk = i % k;
            modkMap.computeIfAbsent(modk, key -> new ArrayList<>()).add(arr[i]);
        }

        long ans = 0L;
        for (List<Integer> list : modkMap.values()) {
            Collections.sort(list);
            int median = list.get(list.size() / 2);
            for (Integer x : list) {
                ans += Math.abs(x - median);
            }
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
2607. 使子数组元素和相等
https://leetcode.cn/problems/make-k-subarray-sums-equal/

第 101 场双周赛 T3。

给你一个下标从 0 开始的整数数组 arr 和一个整数 k 。数组 arr 是一个循环数组。
换句话说，数组中的最后一个元素的下一个元素是数组中的第一个元素，数组中第一个元素的前一个元素是数组中的最后一个元素。
你可以执行下述运算任意次：
- 选中 arr 中任意一个元素，并使其值加上 1 或减去 1 。
执行运算使每个长度为 k 的 子数组 的元素总和都相等，返回所需要的最少运算次数。
子数组 是数组的一个连续部分。
提示：
1 <= k <= arr.length <= 10^5
1 <= arr[i] <= 10^9

裴蜀定理 GCD + 中位数 + 贪心
时间复杂度 O(nlogn)
相似题目: 462. 最少移动次数使数组元素相等 II
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */