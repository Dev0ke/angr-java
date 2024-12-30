public class Solution135 {
    public int candy(int[] ratings) {
        int len = ratings.length;

        // 左往右
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // 右往左
        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i + 1 < len && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
/*
135. 分发糖果
https://leetcode.cn/problems/candy/

n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
你需要按照以下要求，给这些孩子分发糖果：
- 每个孩子至少分配到 1 个糖果。
- 相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
提示：
n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4

左右遍历一次
时间复杂度 O(n)
5,7,8,3,4,2,1
左到右 1,2,3,1,2,1,1
右到左 1,1,2,1,3,2,1
取最大 1,2,3,1,3,2,1
 */