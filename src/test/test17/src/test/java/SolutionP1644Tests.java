import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1644Tests {
    private final SolutionP1644 solutionP1644 = new SolutionP1644();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1644.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1644.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(10);
        TreeNode expected = null;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1644.lowestCommonAncestor(root, p, q)));
    }
}
