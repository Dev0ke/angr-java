public class SolutionP2519 {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        if (k * 2 >= n) {
            return 0;
        }
        BIT left = new BIT(n + 1);
        BIT right = new BIT(n + 1);
        for (int x : nums) {
            right.add(x, 1);
        }
        int ans = 0;
        for (int x : nums) {
            right.add(x, -1);
            if (left.query(x - 1) >= k && right.query(x - 1) >= k) {
                ans++;
            }
            left.add(x, 1);
        }
        return ans;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
$2519. 统计 K-Big 索引的数量
https://leetcode.cn/problems/count-the-number-of-k-big-indices/description/

给定一个 下标从0开始 的整数数组 nums 和一个正整数 k 。
如果满足以下条件，我们称下标 i 为 k-big ：
- 存在至少 k 个不同的索引 idx1 ，满足 idx1 < i 且 nums[idx1] < nums[i] 。
- 存在至少 k 个不同的索引 idx2 ，满足 idx2 > i 且 nums[idx2] < nums[i] 。
返回 k-big 索引的数量。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= nums.length

树状数组。
https://leetcode.cn/problems/count-the-number-of-k-big-indices/solutions/2090475/tong-ji-k-bigqie-pian-shu-liang-shu-zhua-s8kb/
 */