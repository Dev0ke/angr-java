import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedArrayToBST(toArray(head));
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // solution108
    private TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
/*
109. 有序链表转换二叉搜索树
https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/

给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
提示:
head 中的节点数在[0, 2 * 10^4] 范围内
-10^5 <= Node.val <= 10^5

转数组后再调用 sortedArrayToBST()
相似题目: 108. 将有序数组转换为二叉搜索树
https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */