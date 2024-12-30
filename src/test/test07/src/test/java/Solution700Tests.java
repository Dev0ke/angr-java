import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution700Tests {
    private final Solution700 solution700 = new Solution700();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3]");
        int val = 2;
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution700.searchBST(root, val)));
    }
}
