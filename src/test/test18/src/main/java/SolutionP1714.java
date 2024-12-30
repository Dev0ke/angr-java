public class SolutionP1714 {
    private static final int MOD = (int) (1e9 + 7);

    public int[] solve(int[] nums, int[][] queries) {
        int n = nums.length;
        int sqrt = (int) Math.sqrt(n);
        long[][] dp = new long[n][sqrt + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = sqrt; i + j > n - 1; j--) {
                dp[i][j] = nums[i];
            }

            for (int j = Math.min(sqrt, n - 1 - i); j > 0; j--) {
                dp[i][j] = (dp[i + j][j] + nums[i]) % MOD;
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int j = queries[i][0];
            int limit = queries[i][1];
            if (limit <= sqrt) {
                ans[i] = (int) dp[j][limit];
            } else {
                for (int k = j; k < n; k += limit) {
                    ans[i] = (ans[i] + nums[k]) % MOD;
                }
            }
        }

        return ans;
    }
}
/*
$1714. 数组中特殊等间距元素的和
https://leetcode.cn/problems/sum-of-special-evenly-spaced-elements-in-array/description/

给定一个索引从 0 开始的整数类型数组 nums ，包含 n 个非负整数。
另外给定一个（包含查询指令的）数组 queries ，其中 queries[i] = [xi, yi]。 第 i 个查询指令的答案是 nums[j] 中满足该条件的所有元素的和： xi <= j < n 且 (j - xi) 能被 yi 整除。
返回一个数组 answer，其中  answer.length == queries.length 且 answer[i] 是第 i 个查询指令的答案对 10^9 + 7 取模。
提示：
n == nums.length
1 <= n <= 5 * 10^4
0 <= nums[i] <= 10^9
1 <= queries.length <= 1.5 * 10^5
0 <= xi < n
1 <= yi <= 5 * 10^4

平衡空间和时间，两个维度各自取根号 n 个
具体是动态规划的步长只用 根号 n 以内的，这样动态规划记录尾部，元素和时，就可以在 nlogn 时间搞定
查询到 根号 n 以内的，直接动态规划里取出来；根号 n 以外的，直接枚举计算，由于步长大于等于根号 n，最多走根号 n 步，必然能走出去，也就平衡了时间
https://leetcode.cn/problems/sum-of-special-evenly-spaced-elements-in-array/solutions/2568878/yu-niang-niang-1714-shu-zu-zhong-te-shu-8t1hq/
 */