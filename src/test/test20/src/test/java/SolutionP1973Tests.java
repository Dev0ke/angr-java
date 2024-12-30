import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1973Tests {
    private final SolutionP1973 solutionP1973 = new SolutionP1973();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,3,4,2,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1973.equalToDescendants(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,null,2,null]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1973.equalToDescendants(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1973.equalToDescendants(root));
    }
}