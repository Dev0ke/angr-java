import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution2179 {
    /**
     * 树状数组
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     */
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Map<Integer, Integer> nums2IdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums2IdxMap.put(nums2[i], i);
        }

        long cnt = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        // nums1 中枚举 pos1y
        for (int pos1y = 1; pos1y < n - 1; pos1y++) {
            int y = nums1[pos1y];
            int x = nums1[pos1y - 1];
            bit.update(nums2IdxMap.get(x) + 1);
            int pos2y = nums2IdxMap.get(y);
            int t = bit.query(pos2y);
            cnt += (long) t * (n - pos1y - pos2y + t - 1);
        }
        return cnt;
    }

    private static class BinaryIndexedTree {
        int n;
        int[] tree;

        public BinaryIndexedTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }

    /**
     * BitSet - MLE
     */
    public long goodTriplets2(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // 左到右
        Map<Integer, BitSet> leftBitSetMap1 = new HashMap<>();
        Map<Integer, BitSet> leftBitSetMap2 = new HashMap<>();
        BitSet leftBitSet1 = new BitSet(n);
        BitSet leftBitSet2 = new BitSet(n);
        for (int i = 0; i < n; i++) {
            leftBitSet1.set(nums1[i], true);
            leftBitSetMap1.put(nums1[i], (BitSet) leftBitSet1.clone());

            leftBitSet2.set(nums2[i], true);
            leftBitSetMap2.put(nums2[i], (BitSet) leftBitSet2.clone());
        }
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 1; i <= n - 2; i++) {
            BitSet bitSet1 = leftBitSetMap1.get(nums1[i]);
            BitSet bitSet2 = leftBitSetMap2.get(nums1[i]);
            bitSet1.and(bitSet2);
            leftMap.put(nums1[i], bitSet1.cardinality() - 1);
        }

        // 右到左
        Map<Integer, BitSet> rightBitSetMap1 = new HashMap<>();
        Map<Integer, BitSet> rightBitSetMap2 = new HashMap<>();
        BitSet rightBitSet1 = new BitSet(n);
        BitSet rightBitSet2 = new BitSet(n);
        for (int i = n - 1; i >= 0; i--) {
            rightBitSet1.set(nums1[i], true);
            rightBitSetMap1.put(nums1[i], (BitSet) rightBitSet1.clone());

            rightBitSet2.set(nums2[i], true);
            rightBitSetMap2.put(nums2[i], (BitSet) rightBitSet2.clone());
        }
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 1; i <= n - 2; i++) {
            BitSet bitSet1 = rightBitSetMap1.get(nums1[i]);
            BitSet bitSet2 = rightBitSetMap2.get(nums1[i]);
            bitSet1.and(bitSet2);
            rightMap.put(nums1[i], bitSet1.cardinality() - 1);
        }

        // sum
        long sum = 0L;
        for (int i = 1; i <= n - 2; i++) {
            int num = nums1[i];
            sum += (long) leftMap.get(num) * rightMap.get(num);
        }
        return sum;
    }

    /**
     * 暴力解法 - TLE
     * 时间复杂度 O(n^3)
     */
    public long goodTriplets3(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Map<Integer, Integer> nums2IdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums2IdxMap.put(nums2[i], i);
        }

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int num1 = nums1[i];
            for (int j = i + 1; j < n; j++) {
                int num2 = nums1[j];
                if (nums2IdxMap.get(num2) > nums2IdxMap.get(num1)) {
                    for (int k = j + 1; k < n; k++) {
                        int num3 = nums1[k];
                        if (nums2IdxMap.get(num3) > nums2IdxMap.get(num2)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
2179. 统计数组中好三元组数目
https://leetcode.cn/problems/count-good-triplets-in-an-array/

第 72 场双周赛 T4。

给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。
好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。
换句话说，如果我们将 pos1v 记为值 v 在 nums1 中出现的位置，pos2v 为值 v 在 nums2 中的位置，
那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x < pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。
请你返回好三元组的 总数目 。
提示：
n == nums1.length == nums2.length
3 <= n <= 10^5
0 <= nums1[i], nums2[i] <= n - 1
nums1 和 nums2 是 [0, 1, ..., n - 1] 的排列。

本题数据量到 10^5，O(n^3) 的暴力解法妥妥 TLE。
容易想到枚举中心点，比赛时写出 MLE 的解法。
相似题目: 315. 计算右侧小于当前元素的个数
https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
剑指 Offer 51. 数组中的逆序对
https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */