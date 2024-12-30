import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1430Tests {
    private final SolutionP1430 solutionP1430 = new SolutionP1430();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,0,0,1,0,null,null,1,0,0]");
        int[] arr = {0, 1, 0, 1};
        Assertions.assertTrue(solutionP1430.isValidSequence(root, arr));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,0,0,1,0,null,null,1,0,0]");
        int[] arr = {0, 0, 1};
        Assertions.assertFalse(solutionP1430.isValidSequence(root, arr));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,0,0,1,0,null,null,1,0,0]");
        int[] arr = {0, 1, 1};
        Assertions.assertFalse(solutionP1430.isValidSequence(root, arr));
    }
}