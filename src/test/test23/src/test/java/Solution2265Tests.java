import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2265Tests {
    private final Solution2265 solution2265 = new Solution2265();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,8,5,0,1,null,6]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2265.averageOfSubtree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2265.averageOfSubtree(root));
    }
}
