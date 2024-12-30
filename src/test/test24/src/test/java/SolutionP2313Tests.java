import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2313Tests {
    private final SolutionP2313 solutionP2313 = new SolutionP2313();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,4,2,null,1,1,1,0]");
        boolean result = true;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2313.minimumFlips(root, result));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        boolean result = false;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2313.minimumFlips(root, result));
    }
}