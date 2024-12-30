import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100Tests {
    private final Solution100 solution100 = new Solution100();

    @Test
    public void example1() {
        TreeNode p = TreeNode.buildTreeNode("[1,2,3]");
        TreeNode q = TreeNode.buildTreeNode("[1,2,3]");
        Assertions.assertTrue(solution100.isSameTree(p, q));
    }

    @Test
    public void example2() {
        TreeNode p = TreeNode.buildTreeNode("[1,2]");
        TreeNode q = TreeNode.buildTreeNode("[1,null,2]");
        Assertions.assertFalse(solution100.isSameTree(p, q));
    }

    @Test
    public void example3() {
        TreeNode p = TreeNode.buildTreeNode("[1,2,1]");
        TreeNode q = TreeNode.buildTreeNode("[1,1,2]");
        Assertions.assertFalse(solution100.isSameTree(p, q));
    }
}
