import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP298Tests {
    private final SolutionP298 solutionP298 = new SolutionP298();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,3,2,4,null,null,null,5]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP298.longestConsecutive(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,null,3,2,null,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP298.longestConsecutive(root));
    }
}
