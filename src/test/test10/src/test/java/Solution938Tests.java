import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution938Tests {
    private final Solution938 solution938 = new Solution938();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,5,15,3,7,null,18]");
        int low = 7;
        int high = 15;
        int expected = 32;
        Assertions.assertEquals(expected, solution938.rangeSumBST(root, low, high));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[10,5,15,3,7,13,18,1,null,6]");
        int low = 6;
        int high = 10;
        int expected = 23;
        Assertions.assertEquals(expected, solution938.rangeSumBST(root, low, high));
    }
}