import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1120Tests {
    private final SolutionP1120 solutionP1120 = new SolutionP1120();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,6,1]");
        double expected = 6.00000;
        Assertions.assertEquals(expected, solutionP1120.maximumAverageSubtree(root));
    }
}