import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution236Tests {
    private final Solution236 solution236 = new Solution236();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        TreeNode p = root;
        TreeNode q = root.left;
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }
}
