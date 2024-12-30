import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution993Tests {
    private final Solution993 solution993 = new Solution993();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4]");
        int x = 4;
        int y = 3;
        Assertions.assertFalse(solution993.isCousins(root, x, y));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4,null,5]");
        int x = 5;
        int y = 4;
        Assertions.assertTrue(solution993.isCousins(root, x, y));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        int x = 2;
        int y = 3;
        Assertions.assertFalse(solution993.isCousins(root, x, y));
    }
}