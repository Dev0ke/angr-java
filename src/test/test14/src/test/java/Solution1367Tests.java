import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1367Tests {
    private final Solution1367 solution1367 = new Solution1367();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{4, 2, 8});
        TreeNode root = TreeNode.buildTreeNode("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]");
        Assertions.assertTrue(solution1367.isSubPath(head, root));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 4, 2, 6});
        TreeNode root = TreeNode.buildTreeNode("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]");
        Assertions.assertTrue(solution1367.isSubPath(head, root));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 4, 2, 6, 8});
        TreeNode root = TreeNode.buildTreeNode("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]");
        Assertions.assertFalse(solution1367.isSubPath(head, root));
    }
}
