import java.util.ArrayList;
import java.util.List;

public class Solution2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = calc(nums, queries[i]);
        }
        return res;
    }

    // O(nm+nlogn)
    private int calc(String[] nums, int[] query) {
        int k = query[0];
        int trim = query[1];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = nums[i].length();
            String subStr = nums[i].substring(len - trim);
            // idx, num
            list.add(new Node(i, subStr));
        }
        list.sort((o1, o2) -> {
            if (o1.num.equals(o2.num)) {
                return Integer.compare(o1.idx, o2.idx);
            }
            return o1.num.compareTo(o2.num);
        });
        return list.get(k - 1).idx;
    }

    static class Node {
        int idx;
        String num;

        public Node(int idx, String num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
/*
2343. 裁剪数字后查询第 K 小的数字
https://leetcode.cn/problems/query-kth-smallest-trimmed-number/

第 302 场周赛 T3。

给你一个下标从 0 开始的字符串数组 nums ，其中每个字符串 长度相等 且只包含数字。
再给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ki, trimi] 。对于每个 queries[i] ，你需要：
- 将 nums 中每个数字 裁剪 到剩下 最右边 trimi 个数位。
- 在裁剪过后的数字中，找到 nums 中第 ki 小数字对应的 下标 。如果两个裁剪后数字一样大，那么下标 更小 的数字视为更小的数字。
- 将 nums 中每个数字恢复到原本字符串。
请你返回一个长度与 queries 相等的数组 answer，其中 answer[i]是第 i 次查询的结果。
提示：
- 裁剪到剩下 x 个数位的意思是不断删除最左边的数位，直到剩下 x 个数位。
- nums 中的字符串可能会有前导 0 。
提示：
1 <= nums.length <= 100
1 <= nums[i].length <= 100
nums[i] 只包含数字。
所有 nums[i].length 的长度 相同 。
1 <= queries.length <= 100
queries[i].length == 2
1 <= ki <= nums.length
1 <= trimi <= nums[0].length

数据范围不大，直接模拟。
时间复杂度 O((mn+nlogn)l) 其中 n 为 nums.length，m 为 nums[i].length，l 为 queries.length
 */