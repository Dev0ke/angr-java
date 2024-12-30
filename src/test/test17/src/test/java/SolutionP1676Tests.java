import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1676Tests {
    private final SolutionP1676 solutionP1676 = new SolutionP1676();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode[] nodes = new TreeNode[]{root.left.right.right, root.left.right.left};
        TreeNode expected = root.left.right;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1676.lowestCommonAncestor(root, nodes)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode[] nodes = new TreeNode[]{root.right};
        TreeNode expected = root.right;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1676.lowestCommonAncestor(root, nodes)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode[] nodes = new TreeNode[]{root.left.right.left, root.left.left, root.left.right, root.left.right.right};
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1676.lowestCommonAncestor(root, nodes)));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode[] nodes = new TreeNode[]{root.right.left, root.right, root.left.right, root, root.left.right.right,
                root.left, root.left.left, root.left.right.left, root.right.right};
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1676.lowestCommonAncestor(root, nodes)));
    }
}
