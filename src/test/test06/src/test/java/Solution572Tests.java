import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution572Tests {
    private final Solution572 solution572 = new Solution572();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,4,5,1,2]");
        TreeNode subRoot = TreeNode.buildTreeNode("[4,1,2]");
        Assertions.assertTrue(solution572.isSubtree(root, subRoot));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,4,5,1,2,null,null,null,null,0]");
        TreeNode subRoot = TreeNode.buildTreeNode("[4,1,2]");
        Assertions.assertFalse(solution572.isSubtree(root, subRoot));
    }
}
