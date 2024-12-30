import java.util.ArrayList;
import java.util.List;

public class Solution2654 {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int gcdAll = 0;
        for (int x : nums) {
            gcdAll = getGCD(gcdAll, x);
        }
        if (gcdAll != 1) {
            return -1;
        }

        // 1 的个数
        int cnt1 = 0;
        for (int x : nums) {
            if (x == 1) {
                cnt1++;
            }
        }
        if (cnt1 > 0) {
            return n - cnt1;
        }

        // O(n^2)
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int gcd = 0;
            for (int j = i; j < n; j++) {
                gcd = getGCD(gcd, nums[j]);
                if (gcd == 1) {
                    minLen = Math.min(minLen, j - i);
                    break;
                }
            }
        }
        return n + (minLen - 1);
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

    public int minOperations2(int[] nums) {
        int n = nums.length;
        int gcdAll = 0, cnt1 = 0;
        for (int x : nums) {
            gcdAll = getGCD(gcdAll, x);
            if (x == 1) cnt1++;
        }
        if (gcdAll != 1) return -1;
        if (cnt1 > 0) return n - cnt1;

        int minLen = n;
        // gcd, 相同的 gcd 的最晚出现的位置
        List<int[]> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new int[]{nums[i], i});
            // 原地去重
            int j = 0;
            for (int[] p : g) {
                p[0] = getGCD(p[0], nums[i]);
                if (g.get(j)[0] == p[0]) {
                    g.get(j)[1] = p[1]; // 合并相同值，下标取最小的
                } else {
                    g.set(++j, p);
                }
            }
            g.subList(j + 1, g.size()).clear();
            if (g.get(0)[0] == 1) {
                // 这里本来是 i-g.get(0)[1]+1，把 +1 提出来合并到 return 中
                minLen = Math.min(minLen, i - g.get(0)[1]);
            }
        }
        return n + (minLen - 1);
    }
}
/*
2654. 使数组所有元素变成 1 的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/

第 342 场周赛 T4。

给你一个下标从 0 开始的 正 整数数组 nums 。你可以对数组执行以下操作 任意 次：
- 选择一个满足 0 <= i < n - 1 的下标 i ，将 nums[i] 或者 nums[i+1] 两者之一替换成它们的最大公约数。
请你返回使数组 nums 中所有元素都等于 1 的 最少 操作次数。如果无法让数组全部变成 1 ，请你返回 -1 。
两个正整数的最大公约数指的是能整除这两个数的最大正整数。
提示：
2 <= nums.length <= 50
1 <= nums[i] <= 10^6

贪心。
如果数组最大公约数 > 1，则无解；
所有元素都等于 1 的最少操作次数 为 n - cnt1；
否则用最少操作数操作出 1，再做操作；
时间复杂度 O(n^2)
n 扩展到 1e5 做法：
时间复杂度 O(nlogU) 其中 U = max(nums[i])
 */