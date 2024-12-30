import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution617Tests {
    private final Solution617 solution617 = new Solution617();

    @Test
    public void example1() {
        TreeNode root1 = TreeNode.buildTreeNode("[1,3,2,5]");
        TreeNode root2 = TreeNode.buildTreeNode("[2,1,3,null,4,null,7]");
        TreeNode expected = TreeNode.buildTreeNode("[3,4,5,5,4,null,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution617.mergeTrees(root1, root2)));
    }
}
