import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution109Tests {
    private final Solution109 solution109 = new Solution109();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{-10, -3, 0, 5, 9});
        // 一个可能的答案是 [0,-3,9,-10,null,5]
//        TreeNode expected = TreeNode.buildTreeNode("[0,-3,9,-10,null,5]");
        TreeNode expected = TreeNode.buildTreeNode("[0,-10,5,null,-3,null,9]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution109.sortedListToBST(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{});
        TreeNode expected = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution109.sortedListToBST(head)));
    }
}
