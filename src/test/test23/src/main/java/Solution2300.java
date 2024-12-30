import java.util.Arrays;

public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if ((long) spells[i] * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = m - left;
        }
        return res;
    }
}
/*
2300. 咒语和药水的成功对数
https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/

第 80 场双周赛 T2。

给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
提示：
n == spells.length
m == potions.length
1 <= n, m <= 10^5
1 <= spells[i], potions[i] <= 10^5
1 <= success <= 10^10

将 potions 排序后二分找 相乘 大于等于 success 的最小下标，即能求出 能成功组合的 药水 数目。
时间复杂度 O(nlogn)
 */