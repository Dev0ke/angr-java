import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution979Tests {
    private final Solution979 solution979 = new Solution979();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,0,0]");
        int expected = 2;
        Assertions.assertEquals(expected, solution979.distributeCoins(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0,3,0]");
        int expected = 3;
        Assertions.assertEquals(expected, solution979.distributeCoins(root));
    }
}