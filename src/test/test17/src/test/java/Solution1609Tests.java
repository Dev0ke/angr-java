import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1609Tests {
    private final Solution1609 solution1609 = new Solution1609();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,10,4,3,null,7,9,12,8,6,null,null,2]");
        Assertions.assertTrue(solution1609.isEvenOddTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,2,3,3,7]");
        Assertions.assertFalse(solution1609.isEvenOddTree(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[5,9,1,3,5,7]");
        Assertions.assertFalse(solution1609.isEvenOddTree(root));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        Assertions.assertTrue(solution1609.isEvenOddTree(root));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]");
        Assertions.assertTrue(solution1609.isEvenOddTree(root));
    }
}
