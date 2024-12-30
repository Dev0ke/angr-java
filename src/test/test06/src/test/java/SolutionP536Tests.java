import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP536Tests {
    private final SolutionP536 solutionP536 = new SolutionP536();

    @Test
    public void example1() {
        String s = "4(2(3)(1))(6(5))";
        TreeNode expected = TreeNode.buildTreeNode("[4,2,6,3,1,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP536.str2tree(s)));
    }

    @Test
    public void example2() {
        String s = "4(2(3)(1))(6(5)(7))";
        TreeNode expected = TreeNode.buildTreeNode("[4,2,6,3,1,5,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP536.str2tree(s)));
    }

    @Test
    public void example3() {
        String s = "-4(2(3)(1))(6(5)(7))";
        TreeNode expected = TreeNode.buildTreeNode("[-4,2,6,3,1,5,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionP536.str2tree(s)));
    }
}
