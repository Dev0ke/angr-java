import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution3347 {
    // 514ms TreeMap + 差分
    static class V1 {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            Map<Integer, Integer> cnt = new HashMap<>();
            TreeMap<Integer, Integer> diff = new TreeMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum); // cnt[x]++
                diff.putIfAbsent(x, 0); // 把 x 插入 diff，以保证下面能遍历到 x
                // 把 [x-k, x+k] 中的每个整数的出现次数都加一
                diff.merge(x - k, 1, Integer::sum); // diff[x-k]++
                diff.merge(x + k + 1, -1, Integer::sum); // diff[x+k+1]--
            }

            int ans = 0;
            int sumD = 0;
            for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
                Integer i = entry.getKey(), diff_i = entry.getValue(); // diff[i]
                sumD += diff_i;
                ans = Math.max(ans, Math.min(sumD, cnt.getOrDefault(i, 0) + numOperations));
            }
            return ans;
        }
    }

    // 322ms 离散化 + 差分
    static class V2 {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            // 离散化
            int[] yArr = getDiscrete(nums, k);

            int sz = yArr.length;
            int[] cnt = new int[sz + 1];
            int[] diff = new int[sz + 1];
            for (int x : nums) {
                cnt[getId(yArr, x)]++;
                diff[getId(yArr, x - k)]++;
                diff[getId(yArr, x + k + 1)]--;
            }

            int ans = 0;
            int sumD = 0;
            for (int i = 0; i < diff.length; i++) {
                sumD += diff[i];
                ans = Math.max(ans, Math.min(sumD, cnt[i] + numOperations));
            }
            return ans;
        }

        private int[] getDiscrete(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                set.add(x);
                set.add(x - k);
                set.add(x + k + 1);
            }
            int sz = set.size();
            int[] yArr = new int[sz];
            int id = 0;
            for (Integer x : set) {
                yArr[id++] = x;
            }
            Arrays.sort(yArr);
            return yArr;
        }

        private int getId(int[] yArr, int x) {
            return Arrays.binarySearch(yArr, x);
        }
    }
}
/*
3347. 执行操作后元素的最高频率 II
https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/

第 143 场双周赛 T3。

给你一个整数数组 nums 和两个整数 k 和 numOperations 。
你必须对 nums 执行 操作  numOperations 次。每次操作中，你可以：
- 选择一个下标 i ，它在之前的操作中 没有 被选择过。
- 将 nums[i] 增加范围 [-k, k] 中的一个整数。
在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。
一个元素 x 的 频率 指的是它在数组中出现的次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= k <= 10^9
0 <= numOperations <= nums.length

差分解法理解直观一点。
 */