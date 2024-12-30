import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP272Tests {
    private final SolutionP272 solutionP272 = new SolutionP272();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,5,1,3]");
        double target = 3.714286;
        int k = 2;
        List<Integer> expected = List.of(4, 3);
        Assertions.assertEquals(expected, solutionP272.closestKValues(root, target, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        double target = 0.000000;
        int k = 1;
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solutionP272.closestKValues(root, target, k));
    }
}
