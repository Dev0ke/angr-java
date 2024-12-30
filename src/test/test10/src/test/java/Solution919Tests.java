import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution919Tests {
    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        Solution919.CBTInserter cbtInserter = new Solution919.CBTInserter(root);
        Assertions.assertEquals(1, cbtInserter.insert(2));
        TreeNode expected = TreeNode.buildTreeNode("[1,2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6]");
        Solution919.CBTInserter cbtInserter = new Solution919.CBTInserter(root);
        Assertions.assertEquals(3, cbtInserter.insert(7));
        Assertions.assertEquals(4, cbtInserter.insert(8));
        TreeNode expected = TreeNode.buildTreeNode("[1,2,3,4,5,6,7,8]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, cbtInserter.get_root()));
    }
}
