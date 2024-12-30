import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // TreeMap 去重 + 排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] item : items) {
            int preVal = treeMap.getOrDefault(item[0], 0);
            // 大于就替换
            if (item[1] > preVal) {
                treeMap.put(item[0], item[1]);
            }
        }

        // treeMap 转 int[][] sortedItems
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int len = list.size();
        int[][] sortedItems = new int[len][2];
        int[] sortedItemKeys = new int[len];
        for (int i = 0; i < len; i++) {
            sortedItems[i] = list.get(i);
            sortedItemKeys[i] = sortedItems[i][0];
        }

        // 预处理。更新每个价格小于等于 sortedItems[i] 物品的最大美丽值
        for (int i = 1; i < list.size(); i++) {
            sortedItems[i][1] = Math.max(sortedItems[i - 1][1], sortedItems[i][1]);
        }
        // res
        int resLen = queries.length;
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            int idx = binarySearchLeftBound(sortedItemKeys, queries[i]);
            if (idx >= 0) {
                res[i] = sortedItems[idx][1];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(nums, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[] nums, int target, int mid) {
        return nums[mid] <= target;
    }
}
/*
2070. 每一个查询的最大美丽值
https://leetcode.cn/problems/most-beautiful-item-for-each-query/

第 65 场双周赛 T3。

给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。
如果不存在符合条件的物品，那么查询的结果为 0 。
请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。

预处理 + 二分。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */