import java.util.Arrays;

public class SolutionP2113 {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        for (int i = 0; i < q; i++) {
            int t = queries[i][0], idx = queries[i][1];
            t %= 2 * n;
            if (t < n && idx < n - t) {
                ans[i] = nums[t + idx];
            } else if (t > n && idx < t - n) {
                ans[i] = nums[idx];
            }
        }
        return ans;
    }
}
/*
$2113. 查询删除和添加元素后的数组
https://leetcode.cn/problems/elements-in-array-after-removing-and-replacing-elements/description/

给你一个 下标从 0 开始 的数组 nums。一开始，在第 0 分钟，数组没有变化。此后每过一分钟，数组的 最左边 的元素将被移除，直到数组为空。然后，每过一分钟，数组的 尾部 将添加一个元素，添加的顺序和删除的顺序相同，直到数组被复原。此后上述操作无限循环进行。
- 举个例子，如果 nums = [0, 1, 2]，那么数组将按如下流程变化：[0,1,2] → [1,2] → [2] → [] → [0] → [0,1] → [0,1,2] → [1,2] → [2] → [] → [0] → [0,1] → [0,1,2] → ...
然后给你一个长度为 n 的二维数组 queries，其中 queries[j] = [timej, indexj]，表示第 j 个查询。第 j 个查询的答案定义如下：
- 如果在时刻 timej，indexj < nums.length，那么答案是此时的 nums[indexj]；
- 如果在时刻 timej，indexj >= nums.length，那么答案是 -1。
请返回一个长度为 n 的整数数组 ans，其中 ans[j] 为第 j 个查询的答案。
提示:
1 <= nums.length <= 100
0 <= nums[i] <= 100
n == queries.length
1 <= n <= 10^5
queries[j].length == 2
0 <= timej <= 10^5
0 <= indexj < nums.length

根本不需要模拟，2n一循环，每个时刻的坐标都很好推。
https://leetcode.cn/problems/elements-in-array-after-removing-and-replacing-elements/solutions/1463174/python-shu-xue-by-himymben-4ypu/
 */