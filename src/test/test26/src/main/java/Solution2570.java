import java.util.Map;
import java.util.TreeMap;

public class Solution2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] x : nums1) {
            treeMap.put(x[0], x[1]);
        }
        for (int[] x : nums2) {
            treeMap.put(x[0], treeMap.getOrDefault(x[0], 0) + x[1]);
        }

        int[][] res = new int[treeMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            res[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return res;
    }
}
/*
2570. 合并两个二维数组 - 求和法
https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/

第 333 场周赛 T1。

给你两个 二维 整数数组 nums1 和 nums2.
- nums1[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
- nums2[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
每个数组都包含 互不相同 的 id ，并按 id 以 递增 顺序排列。
请你将两个数组合并为一个按 id 以递增顺序排列的数组，并符合下述条件：
- 只有在两个数组中至少出现过一次的 id 才能包含在结果数组内。
- 每个 id 在结果数组中 只能出现一次 ，并且其对应的值等于两个数组中该 id 所对应的值求和。如果某个数组中不存在该 id ，则认为其对应的值等于 0 。
返回结果数组。返回的数组需要按 id 以递增顺序排列。
提示：
1 <= nums1.length, nums2.length <= 200
nums1[i].length == nums2[j].length == 2
1 <= idi, vali <= 1000
数组中的 id 互不相同
数据均按 id 以严格递增顺序排列

TreeMap 模拟
 */