import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2415Tests {
    private final Solution2415 solution2415 = new Solution2415();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,5,8,13,21,34]");
        TreeNode expected = TreeNode.buildTreeNode("[2,5,3,8,13,21,34]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2415.reverseOddLevels(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[7,13,11]");
        TreeNode expected = TreeNode.buildTreeNode("[7,11,13]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2415.reverseOddLevels(root)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]");
        TreeNode expected = TreeNode.buildTreeNode("[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2415.reverseOddLevels(root)));
    }
}
