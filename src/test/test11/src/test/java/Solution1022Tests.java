import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1022Tests {
    private final Solution1022 solution1022 = new Solution1022();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,1,0,1,0,1]");
        int expected = 22;
        Assertions.assertEquals(expected, solution1022.sumRootToLeaf(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1022.sumRootToLeaf(root));
    }
}
