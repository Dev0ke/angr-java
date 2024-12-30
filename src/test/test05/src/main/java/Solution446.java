import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        // 每个 f[i] 均为哈希表，哈希表键值对为 {d : cnt}
        // d : 子序列差值
        // cnt : 以 nums[i] 为结尾，且差值为 d 的子序列数量
        List<Map<Long, Integer>> fList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                Map<Long, Integer> pre = fList.get(j);
                int cnt = cur.getOrDefault(d, 0);
                cnt += pre.getOrDefault(d, 0) + 1;
                cur.put(d, cnt);
            }
            fList.add(cur);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> cur = fList.get(i);
            for (Integer val : cur.values()) {
                ans += val;
            }
        }
        int a1 = 0, an = n - 1;
        int cnt = (a1 + an) * n / 2;
        return ans - cnt;
    }
}
/*
446. 等差数列划分 II - 子序列
https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/

给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
- 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
- 再例如，[1, 1, 2, 5, 7] 不是等差序列。
数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
- 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
题目数据保证答案是一个 32-bit 整数。
提示：
1  <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1

序列 DP
【宫水三叶】详解如何分析「序列 DP」问题（附序列 DP 问题目录） https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/solution/gong-shui-san-xie-xiang-jie-ru-he-fen-xi-ykvk/
时间复杂度 O(n^2)
 */