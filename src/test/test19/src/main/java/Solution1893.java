public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 范围 <= 50 boolean 默认值是 false
        boolean[] rangeArr = new boolean[55];
        for (int[] range : ranges) {
            // 模拟操作
            for (int i = range[0]; i <= range[1]; i++) {
                if (!rangeArr[i]) {
                    rangeArr[i] = true;
                }
            }
        }
        // 校验
        for (int i = left; i <= right; i++) {
            if (!rangeArr[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
1893. 检查是否区域内所有整数都被覆盖
https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered/

第 54 场双周赛 T1。

给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
提示：
1 <= ranges.length <= 50
1 <= starti <= endi <= 50
1 <= left <= right <= 50

由于数组长度非常小，直接进行模拟即可。
 */