import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int ar : arr) {
            treeSet.add(ar);
        }

        // 序号从 1 开始编号。
        // 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
        int idx = 1;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (!treeSet.isEmpty()) {
            hashMap.put(treeSet.pollFirst(), idx++);
        }

        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = hashMap.get(arr[i]);
        }
        return res;
    }
}
/*
1331. 数组序号转换
https://leetcode.cn/problems/rank-transform-of-an-array/

给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
序号代表了一个元素有多大。序号编号的规则如下：
- 序号从 1 开始编号。
- 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
- 每个数字的序号都应该尽可能地小。
提示：
0 <= arr.length <= 10^5
-10^9 <= arr[i] <= 10^9

排序，HashMap 记录序号，再恢复。
 */