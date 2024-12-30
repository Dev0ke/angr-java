import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2593 {
    public long findScore(int[] nums) {
        int n = nums.length;

        // [i, val]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i, nums[i]});
        }
        // Java 关于对象的排序是稳定排序
        list.sort(Comparator.comparingInt(o -> o[1]));

        long res = 0L;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] p = list.get(i);
            if (!visited[p[0]]) {
                res += p[1];
                if (p[0] - 1 >= 0) {
                    visited[p[0] - 1] = true;
                }
                if (p[0] + 1 < n) {
                    visited[p[0] + 1] = true;
                }
            }
        }
        return res;
    }
}
/*
2593. 标记所有元素后数组的分数
https://leetcode.cn/problems/find-score-of-an-array-after-marking-all-elements/

第 100 场双周赛 T3。

给你一个数组 nums ，它包含若干正整数。
一开始分数 score = 0 ，请你按照下面算法求出最后分数：
- 从数组中选择最小且没有被标记的整数。如果有相等元素，选择下标最小的一个。
- 将选中的整数加到 score 中。
- 标记 被选中元素，如果有相邻元素，则同时标记 与它相邻的两个元素 。
- 重复此过程直到数组中所有元素都被标记。
请你返回执行上述算法后最后的分数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

模拟。
自定义排序后模拟（非稳定排序的语言要先按元素大小升序排序，相同元素大小按下标大小升序排序）
时间复杂度 O(nlogn)
 */