import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1379Tests {
    private final Solution1379 solution1379 = new Solution1379();

    @Test
    public void example1() {
        final TreeNode original = TreeNode.buildTreeNode("[7,4,3,null,null,6,19]");
        final TreeNode cloned = TreeNode.buildTreeNode("[7,4,3,null,null,6,19]");
        final TreeNode target = original.right;
        final TreeNode expected = cloned.right;
        TreeNode actual = solution1379.getTargetCopy(original, cloned, target);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, actual));
    }

    @Test
    public void example2() {
        final TreeNode original = TreeNode.buildTreeNode("[7]");
        final TreeNode cloned = TreeNode.buildTreeNode("[7]");
        final TreeNode target = original;
        final TreeNode expected = cloned;
        TreeNode actual = solution1379.getTargetCopy(original, cloned, target);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, actual));
    }

    @Test
    public void example3() {
        final TreeNode original = TreeNode.buildTreeNode("[8,null,6,null,5,null,4,null,3,null,2,null,1]");
        final TreeNode cloned = TreeNode.buildTreeNode("[8,null,6,null,5,null,4,null,3,null,2,null,1]");
        final TreeNode target = original.right.right.right;
        final TreeNode expected = cloned.right.right.right;
        TreeNode actual = solution1379.getTargetCopy(original, cloned, target);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, actual));
    }
}