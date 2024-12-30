import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution104Tests {
    private final Solution104 solution104 = new Solution104();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solution104.maxDepth(root));
    }
}
