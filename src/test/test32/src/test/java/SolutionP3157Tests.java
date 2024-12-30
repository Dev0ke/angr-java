import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3157Tests {
    private final SolutionP3157 solutionP3157 = new SolutionP3157();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[50,6,2,30,80,7]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3157.minimumLevel(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[36,17,10,null,null,24]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3157.minimumLevel(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[5,null,5,null,5]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3157.minimumLevel(root));
    }
}