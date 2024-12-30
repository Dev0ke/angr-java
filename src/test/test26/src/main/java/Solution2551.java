import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(weights[i - 1] + weights[i]);
        }
        Collections.sort(list);

        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += list.get(n - 2 - i) - list.get(i);
        }
        return res;
    }
}
/*
2551. 将珠子放入背包中
https://leetcode.cn/problems/put-marbles-in-bags/

第 330 场周赛 T3。

你有 k 个背包。给你一个下标从 0 开始的整数数组 weights ，其中 weights[i] 是第 i 个珠子的重量。同时给你整数 k 。
请你按照如下规则将所有的珠子放进 k 个背包。
没有背包是空的。
- 如果第 i 个珠子和第 j 个珠子在同一个背包里，那么下标在 i 到 j 之间的所有珠子都必须在这同一个背包中。
- 如果一个背包有下标从 i 到 j 的所有珠子，那么这个背包的价格是 weights[i] + weights[j] 。
一个珠子分配方案的 分数 是所有 k 个背包的价格之和。
请你返回所有分配方案中，最大分数 与 最小分数 的 差值 为多少。
提示：
1 <= k <= weights.length <= 10^5
1 <= weights[i] <= 10^9

注意题目没要求 i < j，意味着可以重复计数
贪心。相加后排序即可。
时间复杂度 O(nlogn)
 */