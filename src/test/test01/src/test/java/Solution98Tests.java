import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution98Tests {
    private final Solution98 solution98 = new Solution98();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        Assertions.assertTrue(solution98.isValidBST(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,4,null,null,3,6]");
        Assertions.assertFalse(solution98.isValidBST(root));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/219966343/
        // 爆 int
        TreeNode root = TreeNode.buildTreeNode("[2147483647]");
        Assertions.assertTrue(solution98.isValidBST(root));
    }
}
