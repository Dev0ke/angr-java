import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution951Tests {
    private final Solution951 solution951 = new Solution951();

    @Test
    public void example1() {
        TreeNode root1 = TreeNode.buildTreeNode("[1,2,3,4,5,6,null,null,null,7,8]");
        TreeNode root2 = TreeNode.buildTreeNode("[1,3,2,null,6,4,5,null,null,null,null,8,7]");
        Assertions.assertTrue(solution951.flipEquiv(root1, root2));
    }

    @Test
    public void example2() {
        TreeNode root1 = TreeNode.buildTreeNode("[]");
        TreeNode root2 = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(solution951.flipEquiv(root1, root2));
    }

    @Test
    public void example3() {
        TreeNode root1 = TreeNode.buildTreeNode("[]");
        TreeNode root2 = TreeNode.buildTreeNode("[1]");
        Assertions.assertFalse(solution951.flipEquiv(root1, root2));
    }
}