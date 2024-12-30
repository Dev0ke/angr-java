import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1660Tests {
    private final SolutionP1660 solutionP1660 = new SolutionP1660();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        root.left.right = root.right;
        TreeNode expected = TreeNode.buildTreeNode("[1,null,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1660.correctBinaryTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[8,3,1,7,null,9,4,2,null,null,null,5,6]");
        root.left.left.right = root.right.right;
        TreeNode expected = TreeNode.buildTreeNode("[8,3,1,null,null,9,4,null,null,5,6]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP1660.correctBinaryTree(root)));
    }
}