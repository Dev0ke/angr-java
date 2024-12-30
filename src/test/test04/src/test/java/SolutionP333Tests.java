import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP333Tests {
    private final SolutionP333 solutionP333 = new SolutionP333();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,5,15,1,8,null,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP333.largestBSTSubtree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,2,3,5,null,2,null,null,null,null,null,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP333.largestBSTSubtree(root));
    }
}
