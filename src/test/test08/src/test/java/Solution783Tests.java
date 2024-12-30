import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution783Tests {
    private final Solution783 solution783 = new Solution783();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,6,1,3]");
        int expected = 1;
        Assertions.assertEquals(expected, solution783.minDiffInBST(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,48,null,null,12,49]");
        int expected = 1;
        Assertions.assertEquals(expected, solution783.minDiffInBST(root));
    }
}
