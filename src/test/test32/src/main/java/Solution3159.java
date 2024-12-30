import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                posList.add(i);
            }
        }
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        for (int i = 0; i < q; i++) {
            int pos = queries[i] - 1;
            if (pos < posList.size()) {
                ans[i] = posList.get(pos);
            }
        }
        return ans;
    }
}
/*
3159. 查询数组中元素的出现位置
https://leetcode.cn/problems/find-occurrences-of-an-element-in-an-array/description/

第 131 场双周赛 T2。

给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
请你返回一个整数数组 answer ，包含所有查询的答案。
提示：
1 <= nums.length, queries.length <= 10^5
1 <= queries[i] <= 10^5
1 <= nums[i], x <= 10^4

预处理下标。
时间复杂度 O(n)。
 */