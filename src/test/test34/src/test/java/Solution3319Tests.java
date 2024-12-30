import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3319Tests {
    private final Solution3319 solution3319 = new Solution3319();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,5,2,5,7,1,8,null,null,6,8]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3319.kthLargestPerfectSubtree(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,7]");
        int k = 1;
        int expected = 7;
        Assertions.assertEquals(expected, solution3319.kthLargestPerfectSubtree(root, k));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        int k = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution3319.kthLargestPerfectSubtree(root, k));
    }
}