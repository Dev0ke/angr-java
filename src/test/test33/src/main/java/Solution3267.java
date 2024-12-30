import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3267 {
    static class V1 {
        // 2154 ms
        public int countPairs(int[] nums) {
            Map<String, List<String>> mp = new HashMap<>();
            int mx = Arrays.stream(nums).max().orElseThrow();
            int len = String.valueOf(mx).length();
            for (int num : nums) {
                String s = String.valueOf(num);
                s = "0".repeat(len - s.length()) + s;
                char[] cs = s.toCharArray();
                Arrays.sort(cs);
                mp.computeIfAbsent(new String(cs), e -> new ArrayList<>()).add(s);
            }

            int ans = 0;
            for (List<String> val : mp.values()) {
                Map<String, Integer> cnt = new HashMap<>();
                for (String s : val) {
                    for (Map.Entry<String, Integer> e2 : cnt.entrySet()) {
                        if (check(e2.getKey(), s)) {
                            ans += e2.getValue();
                        }
                    }
                    cnt.merge(s, 1, Integer::sum);
                }
            }
            return ans;
        }

        private boolean check(String s1, String s2) {
            int maxLen = s1.length();
            int iter = 0;
            char[] d1 = new char[5];
            char[] d2 = new char[5];
            for (int i = 0; i < maxLen; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    d1[iter] = s1.charAt(i);
                    d2[iter] = s2.charAt(i);
                    iter++;
                    if (iter > 4) return false;
                }
            }
            if (iter <= 3) return true;
            return d1[0] == d2[3] && d2[0] == d1[3] && d1[1] == d2[2] && d2[1] == d1[2]
                    || d1[0] == d2[2] && d1[2] == d2[0] && d1[1] == d2[3] && d1[3] == d2[1]
                    || d1[0] == d2[1] && d2[0] == d1[1] && d1[2] == d2[3] && d2[2] == d1[3];
        }
    }

    // 87ms
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
                BitSet s = new BitSet();
                if (mp.containsKey(x)) s.or(mp.get(x));
                mp.computeIfAbsent(x, e -> new BitSet()).set(pos);
                int zz = 0;
                for (int i = 0, v = x; i < m; i++, v /= 10) {
                    digits[zz++] = v % 10;
                }
                for (int i = 0; i < m; i++) {
                    for (int j = i + 1; j < m; j++) {
                        if (digits[i] == digits[j]) continue;
                        int y = x + (digits[j] - digits[i]) * (pow10[i] - pow10[j]);
                        if (mp.containsKey(y)) s.or(mp.get(y));
                        mp.computeIfAbsent(y, e -> new BitSet()).set(pos);
                    }
                }
                ans += s.cardinality();
            }
            return ans;
        }
    }
}
/*
3267. 统计近似相等数对 II
https://leetcode.cn/problems/count-almost-equal-pairs-ii/description/

第 412 场周赛 T4。

注意：在这个问题中，操作次数增加为至多 两次 。
给你一个正整数数组 nums 。
如果我们执行以下操作 至多两次 可以让两个整数 x 和 y 相等，那么我们称这个数对是 近似相等 的：
- 选择 x 或者 y  之一，将这个数字中的两个数位交换。
请你返回 nums 中，下标 i 和 j 满足 i < j 且 nums[i] 和 nums[j] 近似相等 的数对数目。
注意 ，执行操作后得到的整数可以有前导 0 。
提示：
2 <= nums.length <= 5000
1 <= nums[i] < 10^7

补前导 0。哈希表 枚举。
时间复杂度 O(n + nlogU)。其中 logU = 8。
灵神有一种暴力做法只需 892ms。
rating 2560 (clist.by)
 */