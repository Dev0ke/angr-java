import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2773Tests {
    private final SolutionP2773 solutionP2773 = new SolutionP2773();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,null,4,5]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2773.heightOfTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2773.heightOfTree(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,null,4,null,5,6]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2773.heightOfTree(root));
    }
}