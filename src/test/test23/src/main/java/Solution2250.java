import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2250 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // 1 <= hi, yj <= 100
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int[] rectangle : rectangles) {
            int xi = rectangle[0];
            int yi = rectangle[1];
            treeMap.computeIfAbsent(yi, key -> new ArrayList<>()).add(xi);
        }
        // 按 xi 升序排序
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // 二分统计答案
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            // 如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
            Map<Integer, List<Integer>> tailMap = treeMap.tailMap(y, true);

            int cnt = 0;
            for (List<Integer> list : tailMap.values()) {
                int idx = binarySearchLeftBound(list, x);
                cnt += list.size() - idx;
            }
            res[i] = cnt;
        }
        return res;
    }

    private int binarySearchLeftBound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
2250. 统计包含每个点的矩形数目
https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point/

第 290 场周赛 T3。

给你一个二维整数数组 rectangles ，其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi 。
给你一个二维整数数组 points ，其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点。
第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi) 。
请你返回一个整数数组 count ，长度为 points.length，其中 count[j]是 包含 第 j 个点的矩形数目。
如果 0 <= xj <= li 且 0 <= yj <= hi ，那么我们说第 i 个矩形包含第 j 个点。如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
提示：
1 <= rectangles.length, points.length <= 5 * 10^4
rectangles[i].length == points[j].length == 2
1 <= li, xj <= 10^9
1 <= hi, yj <= 100
所有 rectangles 互不相同 。
所有 points 互不相同 。

二维偏序问题。
注意到 hi, yj 取值范围只有 100，可以直接枚举。对于每个 hi，二分找出边界后再求和即可。
相似题目: 34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */