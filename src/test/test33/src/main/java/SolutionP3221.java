public class SolutionP3221 {
    public long maxScore(int[] nums) {
        long res = 0;

        // 初始化nums[0]为一个大数
        nums[0] = Integer.MAX_VALUE / 2; // 使用Integer.MAX_VALUE的一半来避免溢出
        int j = nums.length - 1;

        // 从后往前遍历数组，除了最后一个元素
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] > nums[j]) {
                res += (long) (j - i) * nums[j];
                j = i;
            }
        }

        // 加上最后一个区间的贡献
        res += (long) (j - 0) * nums[j];

        return res;
    }
}
/*
$3221. 最大数组跳跃得分 II
https://leetcode.cn/problems/maximum-array-hopping-score-ii/description/

给定一个数组 nums，你必须从索引 0 开始跳跃，直到到达数组的最后一个元素，使得获取 最大 分数。
每一次 跳跃 中，你可以从下标 i 跳到一个 j > i 的下标，并且可以得到 (j - i) * nums[j] 的分数。
返回你能够取得的最大分数。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

从后往前走，遇到高的就跳，分数增加 (j-i) * nums[j]，直到走到nums[0]
https://leetcode.cn/problems/maximum-array-hopping-score-ii/solutions/2911294/python-ontan-xin-jie-fa-by-songyulong-hlph/
相似题目: $3205. 最大数组跳跃得分 I
https://leetcode.cn/problems/maximum-array-hopping-score-i/description/
 */