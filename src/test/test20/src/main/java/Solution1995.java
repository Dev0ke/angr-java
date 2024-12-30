public class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int a = 0; a < len; a++) {
            for (int b = a + 1; b < len; b++) {
                for (int c = b + 1; c < len; c++) {
                    for (int d = c + 1; d < len; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
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
1995. 统计特殊四元组
https://leetcode.cn/problems/count-special-quadruplets/

第 257 场周赛 T1。

给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
- nums[a] + nums[b] + nums[c] == nums[d] ，且
- a < b < c < d
提示：
4 <= nums.length <= 50
1 <= nums[i] <= 100

四层循环暴力
 */