import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1602Tests {
    private final SolutionP1602 solutionP1602 = new SolutionP1602();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4,5,6]");
        TreeNode u = new TreeNode(4);
        TreeNode expected = new TreeNode(5);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1602.findNearestRightNode(root, u)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,null,4,2]");
        TreeNode u = new TreeNode(2);
        TreeNode expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1602.findNearestRightNode(root, u)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        TreeNode u = new TreeNode(1);
        TreeNode expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1602.findNearestRightNode(root, u)));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[3,4,2,null,null,null,1]");
        TreeNode u = new TreeNode(4);
        TreeNode expected = new TreeNode(2);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected.val, solutionP1602.findNearestRightNode(root, u).val));
    }
}
