import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP776Tests {
    private final SolutionP776 solutionP776 = new SolutionP776();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,6,1,3,5,7]");
        int target = 2;
        TreeNode[] expected = {TreeNode.buildTreeNode("[2,1]"), TreeNode.buildTreeNode("[4,3,6,null,null,5,7]")};
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP776.splitBST(root, target)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int target = 1;
        TreeNode[] expected = {TreeNode.buildTreeNode("[1]"), TreeNode.buildTreeNode("[]")};
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP776.splitBST(root, target)));
    }
}