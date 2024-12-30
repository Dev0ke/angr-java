import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1145Tests {
    private final Solution1145 solution1145 = new Solution1145();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,7,8,9,10,11]");
        int n = 11;
        int x = 3;
        Assertions.assertTrue(solution1145.btreeGameWinningMove(root, n, x));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int n = 3;
        int x = 1;
        Assertions.assertFalse(solution1145.btreeGameWinningMove(root, n, x));
    }
}
