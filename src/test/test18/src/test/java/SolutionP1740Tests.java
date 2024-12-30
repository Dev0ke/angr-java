import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1740Tests {
    private final SolutionP1740 solutionP1740 = new SolutionP1740();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        int p = 5;
        int q = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1740.findDistance(root, p, q));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        int p = 5;
        int q = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1740.findDistance(root, p, q));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        int p = 5;
        int q = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1740.findDistance(root, p, q));
    }
}