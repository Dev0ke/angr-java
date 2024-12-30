import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution513Tests {
    private final Solution513 solution513 = new Solution513();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        int expected = 1;
        Assertions.assertEquals(expected, solution513.findBottomLeftValue(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,null,5,6,null,null,7]");
        int expected = 7;
        Assertions.assertEquals(expected, solution513.findBottomLeftValue(root));
    }
}
