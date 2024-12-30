import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution662Tests {
    private final Solution662 solution662 = new Solution662();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,5,3,null,9]");
        int expected = 4;
        Assertions.assertEquals(expected, solution662.widthOfBinaryTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,5,null,null,9,6,null,7]");
        int expected = 7;
        Assertions.assertEquals(expected, solution662.widthOfBinaryTree(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,5]");
        int expected = 2;
        Assertions.assertEquals(expected, solution662.widthOfBinaryTree(root));
    }
}
