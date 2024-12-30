import java.util.Arrays;

public class Solution1819 {
    // 93ms
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        boolean[] has = new boolean[mx + 1];
        for (int v : nums) {
            has[v] = true;
        }
        int ans = 0;
        for (int i = 1; i <= mx; i++) {
            int g = 0; // 0 和任何数 x 的最大公约数都是 x
            for (int j = i; j <= mx && g != i; j += i) { // 枚举 i 的倍数 j
                if (has[j]) { // 如果 j 在 nums 中
                    g = getGCD(g, j); // 更新最大公约数
                }
            }
            if (g == i) ans++; // 找到一个答案
        }
        return ans;
    }

    // 82ms
    public int countDifferentSubsequenceGCDs2(int[] nums) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        boolean[] has = new boolean[mx + 1];
        int ans = 0;
        for (int v : nums) {
            if (!has[v]) {
                has[v] = true;
                ans++; // 单独一个数也算
            }
        }
        for (int i = 1; i <= mx / 3; i++) { // i 也可以只枚举到 mx/3
            if (has[i]) continue;
            int g = 0; // 0 和任何数 x 的最大公约数都是 x
            for (int j = i; j <= mx && g != i; j += i) { // 枚举 i 的倍数 j
                if (has[j]) { // 如果 j 在 nums 中
                    g = getGCD(g, j); // 更新最大公约数
                }
            }
            if (g == i) ans++; // 找到一个答案
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
1819. 序列中不同最大公约数的数目
https://leetcode.cn/problems/number-of-different-subsequences-gcds/description/

给你一个由正整数组成的数组 nums 。
数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
- 例如，序列 [4,6,16] 的最大公约数是 2 。
数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
- 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 2 * 10^5

枚举GCD + 循环优化
时间复杂度 O(n + UlogU)。
https://leetcode.cn/problems/number-of-different-subsequences-gcds/solutions/2061079/ji-bai-100mei-ju-gcdxun-huan-you-hua-pyt-get7/
 */