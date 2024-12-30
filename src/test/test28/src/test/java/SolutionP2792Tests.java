import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2792Tests {
    private final SolutionP2792 solutionP2792 = new SolutionP2792();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[7,6,5,4,3,2,1]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2792.countGreatEnoughNodes(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2792.countGreatEnoughNodes(root, k));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[3,2,2]");
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2792.countGreatEnoughNodes(root, k));
    }
}