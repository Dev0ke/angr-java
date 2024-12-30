import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                mp.computeIfAbsent(i + j, e -> new ArrayList<>()).add(nums.get(i).get(j));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> value : mp.values()) {
            ans.addAll(value);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
1424. 对角线遍历 II
https://leetcode.cn/problems/diagonal-traverse-ii/description/

给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i].length <= 10^5
1 <= nums[i][j] <= 10^9
nums 中最多有 10^5 个数字。

按 i+j 分组排序。
时间复杂度 O(nlogn)。其中 n 表示 nums 中的数字个数。
 */