import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1373Tests {
    private final Solution1373 solution1373 = new Solution1373();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]");
        int expected = 20;
        Assertions.assertEquals(expected, solution1373.maxSumBST(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,3,null,1,2]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1373.maxSumBST(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[-4,-2,-5]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1373.maxSumBST(root));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        int expected = 6;
        Assertions.assertEquals(expected, solution1373.maxSumBST(root));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,3,null,6,3]");
        int expected = 7;
        Assertions.assertEquals(expected, solution1373.maxSumBST(root));
    }
}
