import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP663Tests {
    private final SolutionP663 solutionP663 = new SolutionP663();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,10,10,null,null,2,3]");
        Assertions.assertTrue(solutionP663.checkEqualTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,10,null,null,2,20]");
        Assertions.assertFalse(solutionP663.checkEqualTree(root));
    }
}