import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution173Tests {
    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[7,3,15,null,null,9,20]");
        Solution173.BSTIterator bstIterator = new Solution173.BSTIterator(root);
        Assertions.assertEquals(3, bstIterator.next());
        Assertions.assertEquals(7, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(9, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(15, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(20, bstIterator.next());
        Assertions.assertFalse(bstIterator.hasNext());
    }
}
