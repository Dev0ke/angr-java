import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1448Tests {
    private final Solution1448 solution1448 = new Solution1448();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,4,3,null,1,5]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1448.goodNodes(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,3,null,4,2]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1448.goodNodes(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1448.goodNodes(root));
    }
}