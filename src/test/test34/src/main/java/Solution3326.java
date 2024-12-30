public class Solution3326 {
    static int mx = (int) 1e6;
    static int[] lpf;

    static {
        // 埃氏筛 预处理 最小质因子
        lpf = new int[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j <= mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                nums[i] = lpf[nums[i]];
                if (nums[i] > nums[i + 1]) return -1;
                ans++;
            }
        }
        return ans;
    }
}
/*
3326. 使数组非递减的最少除法操作次数
https://leetcode.cn/problems/minimum-division-operations-to-make-array-non-decreasing/description/

第 420 场周赛 T3。

给你一个整数数组 nums 。
一个正整数 x 的任何一个 严格小于 x 的 正 因子都被称为 x 的 真因数 。比方说 2 是 4 的 真因数，但 6 不是 6 的 真因数。
你可以对 nums 的任何数字做任意次 操作 ，一次 操作 中，你可以选择 nums 中的任意一个元素，将它除以它的 最大真因数 。
你的目标是将数组变为 非递减 的，请你返回达成这一目标需要的 最少操作 次数。
如果 无法 将数组变成非递减的，请你返回 -1 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

注意：除以它的 最大真因数，即变为 LPF。
 */