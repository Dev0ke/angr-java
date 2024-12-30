import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1530Tests {
    private final Solution1530 solution1530 = new Solution1530();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        int distance = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1530.countPairs(root, distance));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,7]");
        int distance = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1530.countPairs(root, distance));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[7,1,4,6,null,5,3,null,null,null,null,null,2]");
        int distance = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1530.countPairs(root, distance));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[100]");
        int distance = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1530.countPairs(root, distance));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,1]");
        int distance = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1530.countPairs(root, distance));
    }
}