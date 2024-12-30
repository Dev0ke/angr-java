import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1214Tests {
    private final SolutionP1214 solutionP1214 = new SolutionP1214();

    @Test
    public void example1() {
        TreeNode root1 = TreeNode.buildTreeNode("[2,1,4]");
        TreeNode root2 = TreeNode.buildTreeNode("[1,0,3]");
        int target = 5;
        Assertions.assertTrue(solutionP1214.twoSumBSTs(root1, root2, target));
    }

    @Test
    public void example2() {
        TreeNode root1 = TreeNode.buildTreeNode("[0,-10,10]");
        TreeNode root2 = TreeNode.buildTreeNode("[5,1,7,0,2]");
        int target = 18;
        Assertions.assertFalse(solutionP1214.twoSumBSTs(root1, root2, target));
    }
}