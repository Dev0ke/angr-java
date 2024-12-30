import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution958Tests {
    private final Solution958 solution958 = new Solution958();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6]");
        Assertions.assertTrue(solution958.isCompleteTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,null,7]");
        Assertions.assertFalse(solution958.isCompleteTree(root));
    }
}