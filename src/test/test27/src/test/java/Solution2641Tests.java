import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2641Tests {
    private final Solution2641 solution2641 = new Solution2641();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,9,1,10,null,7]");
        TreeNode expected = TreeNode.buildTreeNode("[0,0,0,7,7,null,11]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2641.replaceValueInTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,2]");
        TreeNode expected = TreeNode.buildTreeNode("[0,0,0]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2641.replaceValueInTree(root)));
    }
}