import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution2597 {
    static class V1 {
        private int[] nums;
        private int k;
        private int[] cnt;

        public int beautifulSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            this.nums = nums;
            this.k = k;
            cnt = new int[1001];
            return dfs(0) - 1;
        }

        private int dfs(int i) {
            if (i == nums.length) {
                return 1;
            }
            // 不选
            int res = dfs(i + 1);
            // 选
            if (nums[i] - k < 0 || cnt[nums[i] - k] <= 0) {
                cnt[nums[i]]++;
                res += dfs(i + 1);
                cnt[nums[i]]--;
            }
            return res;
        }
    }

    static class V2 {
        public int beautifulSubsets(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);

            int res = 0;
            // n * 2^n
            for (int mask = 1; mask < (1 << n); mask++) {
                boolean flag = true;
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 1) {
                        if (set.contains(nums[i] - k)) {
                            flag = false;
                            break;
                        }
                        set.add(nums[i]);
                    }
                }
                if (flag) {
                    res++;
                }
            }
            return res;
        }
    }

    // O(nlogn)
    static class V3 {
        public int beautifulSubsets(int[] nums, int k) {
            Map<Integer, TreeMap<Integer, Integer>> groups = new HashMap<>();
            for (int x : nums)
                groups.computeIfAbsent((x % k), key -> new TreeMap<>()).merge(x, 1, Integer::sum);
            int ans = 1;
            for (TreeMap<Integer, Integer> g : groups.values()) {
                int m = g.size();
                int[] f = new int[m + 1];
                f[0] = 1;
                int i = 1, pre = 0;
                for (Map.Entry<Integer, Integer> e : g.entrySet()) {
                    int cur = e.getKey();
                    if (i > 1 && cur - pre == k)
                        f[i] = f[i - 1] + f[i - 2] * ((1 << e.getValue()) - 1);
                    else
                        f[i] = f[i - 1] << e.getValue();
                    pre = cur;
                    ++i;
                }
                ans *= f[m];
            }
            return ans - 1;
        }
    }
}
/*
2597. 美丽子集的数目
https://leetcode.cn/problems/the-number-of-beautiful-subsets/

第 337 场周赛 T3。

给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
返回数组 nums 中 非空 且 美丽 的子集数目。
nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
提示：
1 <= nums.length <= 20
1 <= nums[i], k <= 1000

回溯。
时间复杂度 O(2^n)
注意本题卡常。若使用 状态压缩枚举会 TLE（时间复杂度 O(n*2^n)）
相似题目: 78. 子集
https://leetcode.cn/problems/subsets/
$2638. 统计 K-Free 子集的总数
https://leetcode.cn/problems/count-the-number-of-k-free-subsets/description/
 */