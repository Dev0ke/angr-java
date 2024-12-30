import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2331Tests {
    private final Solution2331 solution2331 = new Solution2331();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3,null,null,0,1]");
        Assertions.assertTrue(solution2331.evaluateTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        Assertions.assertFalse(solution2331.evaluateTree(root));
    }
}
