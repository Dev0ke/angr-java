import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution3265 {
    static class V1 {
        public int countPairs(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check(nums[i], nums[j])) ans++;
                }
            }
            return ans;
        }

        private boolean check(int a, int b) {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            int maxLen = Math.max(s1.length(), s2.length());
            s1 = "0".repeat(maxLen - s1.length()) + s1;
            s2 = "0".repeat(maxLen - s2.length()) + s2;
            int diff = 0;
            for (int i = 0; i < maxLen; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
            }
            if (diff > 2) return false;
            char[] s = s1.toCharArray();
            char[] t = s2.toCharArray();
            Arrays.sort(s);
            Arrays.sort(t);
            return Arrays.equals(s, t);
        }
    }

    // 17ms
    static class V2 {
        private static final int[] pow10 = {1, 10, 100, 1000, 10000, 100000, 1000000};

        public int countPairs(int[] nums) {
            int n = nums.length;
            int m = String.valueOf(Arrays.stream(nums).max().orElseThrow()).length();
            int ans = 0;
            Map<Integer, BitSet> mp = new HashMap<>();
            int[] digits = new int[m];
            for (int pos = 0; pos < n; pos++) {
                int x = nums[pos];
//            BitSet s = new BitSet();
//            if (mp.containsKey(x)) s.or(mp.get(x));
                if (mp.containsKey(x)) ans += mp.get(x).cardinality();
                mp.computeIfAbsent(x, e -> new BitSet()).set(pos);
                int zz = 0;
                for (int i = 0, v = x; i < m; i++, v /= 10) {
                    digits[zz++] = v % 10;
                }
                for (int i = 0; i < m; i++) {
                    for (int j = i + 1; j < m; j++) {
                        if (digits[i] == digits[j]) continue;
                        int y = x + (digits[j] - digits[i]) * (pow10[i] - pow10[j]);
//                    if (mp.containsKey(y)) s.or(mp.get(y));
                        mp.computeIfAbsent(y, e -> new BitSet()).set(pos);
                    }
                }
//            ans += s.cardinality();
            }
            return ans;
        }
    }
}
/*
3265. 统计近似相等数对 I
https://leetcode.cn/problems/count-almost-equal-pairs-i/description/

第 412 场周赛 T2。

给你一个正整数数组 nums 。
如果我们执行以下操作 至多一次 可以让两个整数 x 和 y 相等，那么我们称这个数对是 近似相等 的：
- 选择 x 或者 y  之一，将这个数字中的两个数位交换。
请你返回 nums 中，下标 i 和 j 满足 i < j 且 nums[i] 和 nums[j] 近似相等 的数对数目。
注意 ，执行操作后一个整数可以有前导 0 。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 10^6

暴力。
时间复杂度 O(n^2)。
 */