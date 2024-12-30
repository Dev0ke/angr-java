import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution872Tests {
    private final Solution872 solution872 = new Solution872();

    @Test
    public void example1() {
        TreeNode root1 = TreeNode.buildTreeNode("[3,5,1,6,2,9,8,null,null,7,4]");
        TreeNode root2 = TreeNode.buildTreeNode("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]");
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example2() {
        TreeNode root1 = TreeNode.buildTreeNode("[1]");
        TreeNode root2 = TreeNode.buildTreeNode("[1]");
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example3() {
        TreeNode root1 = TreeNode.buildTreeNode("[1]");
        TreeNode root2 = TreeNode.buildTreeNode("[2]");
        Assertions.assertFalse(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example4() {
        TreeNode root1 = TreeNode.buildTreeNode("[1,2]");
        TreeNode root2 = TreeNode.buildTreeNode("[2,2]");
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example5() {
        TreeNode root1 = TreeNode.buildTreeNode("[1,2,3]");
        TreeNode root2 = TreeNode.buildTreeNode("[1,3,2]");
        Assertions.assertFalse(solution872.leafSimilar(root1, root2));
    }
}
