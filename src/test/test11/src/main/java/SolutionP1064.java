public class SolutionP1064 {
    public int fixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
/*
$1064. 不动点
https://leetcode.cn/problems/fixed-point/

第 1 场双周赛 T1。

给定已经按 升序 排列、由不同整数组成的数组 arr，返回满足 arr[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
提示：
1 <= arr.length < 10^4
-10^9 <= arr[i] <= 10^9

数据量不大。直接 时间复杂度 O(n) 即可。
 */