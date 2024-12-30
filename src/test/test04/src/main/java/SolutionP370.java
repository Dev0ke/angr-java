public class SolutionP370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        DiffArray diffArray = new DiffArray(length);
        for (int[] update : updates) {
            diffArray.rangeAdd(update[0], update[1], update[2]);
        }
        return diffArray.getRawArray();
    }

    private static class DiffArray {
        private final int[] diff;

        public DiffArray(int n) {
            diff = new int[n + 1];
        }

        // nums[i,j] 增加 inc
        public void rangeAdd(int i, int j, int inc) {
            diff[i] += inc;
            diff[j + 1] -= inc;
        }

        // 获取原数组
        public int[] getRawArray() {
            int[] res = new int[diff.length - 1];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
/*
$370. 区间加法
https://leetcode.cn/problems/range-addition/

假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]
（包括 startIndex 和 endIndex）增加 inc。
请你返回 k 次操作后的数组。

差分数组。
 */