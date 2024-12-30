import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution230Tests {
    private final Solution230 solution230 = new Solution230();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,4,null,2]");
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution230.kthSmallest(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,null,1]");
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution230.kthSmallest(root, k));
    }
}
