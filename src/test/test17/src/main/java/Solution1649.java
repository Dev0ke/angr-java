import java.util.Arrays;

public class Solution1649 {
    static final long MOD = (long) (1e9 + 7);

    public int createSortedArray(int[] instructions) {
        int ub = Arrays.stream(instructions).max().orElseThrow();
        BIT bit = new BIT(ub);
        long ans = 0;
        for (int i = 0; i < instructions.length; ++i) {
            int x = instructions[i];
            int smaller = bit.query(x - 1);
            int larger = i - bit.query(x);
            ans += Math.min(smaller, larger);
            bit.add(x, 1);
        }
        return (int) (ans % MOD);
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
1649. 通过指令创建有序数组
https://leetcode.cn/problems/create-sorted-array-through-instructions/description/

给你一个整数数组 instructions ，你需要根据 instructions 中的元素创建一个有序数组。一开始你有一个空的数组 nums ，你需要 从左到右 遍历 instructions 中的元素，将它们依次插入 nums 数组中。每一次插入操作的 代价 是以下两者的 较小值 ：
- nums 中 严格小于  instructions[i] 的数字数目。
- nums 中 严格大于  instructions[i] 的数字数目。
比方说，如果要将 3 插入到 nums = [1,2,3,5] ，那么插入操作的 代价 为 min(2, 1) (元素 1 和  2 小于 3 ，元素 5 大于 3 ），插入后 nums 变成 [1,2,3,3,5] 。
请你返回将 instructions 中所有元素依次插入 nums 后的 总最小代价 。由于答案会很大，请将它对 10^9 + 7 取余 后返回。
提示：
1 <= instructions.length <= 10^5
1 <= instructions[i] <= 10^5

分析题目要求，需要实现三个操作：
向数据结构中添加一个元素 x；
给定一个元素 x，查询数据结构中在 [1,x−1] 范围内的元素个数；
给定一个元素 x，查询数据结构在 [x+1,UB] 范围内的元素个数，其中 UB 表示所有涉及到操作的元素的最大值，在本题中这个值不会超过 10^5 。
https://leetcode.cn/problems/create-sorted-array-through-instructions/solutions/477302/tong-guo-zhi-ling-chuang-jian-you-xu-shu-zu-by-zer/
 */