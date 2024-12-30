import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution606Tests {
    private final Solution606 solution606 = new Solution606();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4]");
        String expected = "1(2(4))(3)";
        Assertions.assertEquals(expected, solution606.tree2str(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        String expected = "1(2()(4))(3)";
        Assertions.assertEquals(expected, solution606.tree2str(root));
    }
}