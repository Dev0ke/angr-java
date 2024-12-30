import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1339Tests {
    private final Solution1339 solution1339 = new Solution1339();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6]");
        int expected = 110;
        Assertions.assertEquals(expected, solution1339.maxProduct(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,3,4,null,null,5,6]");
        int expected = 90;
        Assertions.assertEquals(expected, solution1339.maxProduct(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,9,10,7,8,6,5,4,11,1]");
        int expected = 1025;
        Assertions.assertEquals(expected, solution1339.maxProduct(root));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1,1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1339.maxProduct(root));
    }
}