import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP156Tests {
    private final SolutionP156 solutionP156 = new SolutionP156();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // expected
        TreeNode expected = new TreeNode(4);
        expected.left = new TreeNode(5);
        expected.right = new TreeNode(2);
        expected.right.left = new TreeNode(3);
        expected.right.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP156.upsideDownBinaryTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode();
        // expected
        TreeNode expected = new TreeNode();
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP156.upsideDownBinaryTree(root)));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        // expected
        TreeNode expected = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP156.upsideDownBinaryTree(root)));
    }
}
