import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP549Tests {
    private final SolutionP549 solutionP549 = new SolutionP549();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP549.longestConsecutive(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP549.longestConsecutive(root));
    }
}
