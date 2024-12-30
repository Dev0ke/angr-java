import java.util.ArrayList;
import java.util.List;

public class Solution2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        int size = nums.size();

        List<List<Integer>> resList = new ArrayList<>();
        for (int query : queries) {
            List<Integer> res = new ArrayList<>();

            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (nums.get(mid) > query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res.add(left - 1 >= 0 ? nums.get(left - 1) : -1);

            left = 0;
            right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (nums.get(mid) >= query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res.add(left < size ? nums.get(left) : -1);

            resList.add(res);
        }
        return resList;
    }

    // BST 中序遍历
    private void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }
}
/*
2476. 二叉搜索树最近节点查询
https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/

第 320 场周赛 T2。

给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
返回数组 answer 。
提示：
树中节点的数目在范围 [2, 10^5] 内
1 <= Node.val <= 10^6
n == queries.length
1 <= n <= 10^5
1 <= queries[i] <= 10^6

中序遍历 + 二分查找
时间复杂度 O(qlogn)
 */