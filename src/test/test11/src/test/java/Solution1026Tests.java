import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1026Tests {
    private final Solution1026 solution1026 = new Solution1026();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[8,3,10,1,6,null,14,null,null,4,7,13]");
        int expected = 7;
        Assertions.assertEquals(expected, solution1026.maxAncestorDiff(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,null,0,3]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1026.maxAncestorDiff(root));
    }
}
