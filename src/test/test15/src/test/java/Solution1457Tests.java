import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1457Tests {
    private final Solution1457 solution1457 = new Solution1457();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,1,3,1,null,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1457.pseudoPalindromicPaths(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,1,1,3,null,null,null,null,null,1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1457.pseudoPalindromicPaths(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[9]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1457.pseudoPalindromicPaths(root));
    }
}