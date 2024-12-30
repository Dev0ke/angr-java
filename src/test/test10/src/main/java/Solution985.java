public class Solution985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                sum += x;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int val = queries[i][0], index = queries[i][1];
            if (nums[index] % 2 == 0) sum -= nums[index];
            nums[index] += val;
            if (nums[index] % 2 == 0) sum += nums[index];
            ans[i] = sum;
        }
        return ans;
    }
}
/*
985. 查询后的偶数和
https://leetcode.cn/problems/sum-of-even-numbers-after-queries/description/

给出一个整数数组 A 和一个查询数组 queries。
对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
（此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
提示：
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
1 <= queries.length <= 10000
-10000 <= queries[i][0] <= 10000
0 <= queries[i][1] < A.length

模拟。先减后加。
时间复杂度 O(n + q)。
 */