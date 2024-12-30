public class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int span = m * k;
        for (int L = 0; L + span <= n; L++) { // 枚举起点
            int i;
            for (i = 0; i < span; i++) {
                // a[i] == a[i%m]，加上偏移量
                if (arr[i + L] != arr[i % m + L]) break;
            }
            if (i == span) return true;
        }
        return false;
    }
}
/*
1566. 重复至少 K 次且长度为 M 的模式
https://leetcode.cn/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/

给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
提示：
2 <= arr.length <= 100
1 <= arr[i] <= 100
1 <= m <= 100
2 <= k <= 100

枚举。
时间复杂度 O(nmk)。
 */