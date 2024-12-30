import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP250Tests {
    private final SolutionP250 solutionP250 = new SolutionP250();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,5,5,5,null,5]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP250.countUnivalSubtrees(root));
    }
}
