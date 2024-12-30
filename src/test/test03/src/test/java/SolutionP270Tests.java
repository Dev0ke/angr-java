import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP270Tests {
    private final SolutionP270 solutionP270 = new SolutionP270();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,5,1,3]");
        double target = 3.714286;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP270.closestValue(root, target));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2]");
        double target = 3.714286;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP270.closestValue(root, target));
    }
}