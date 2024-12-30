import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1932Tests {
    private final Solution1932 solution1932 = new Solution1932();

    @Test
    public void example1() {
        List<TreeNode> trees = List.of(
                TreeNode.buildTreeNode("[2,1]"),
                TreeNode.buildTreeNode("[3,2,5]"),
                TreeNode.buildTreeNode("[5,4]")
        );
        TreeNode expected = TreeNode.buildTreeNode("[3,2,5,1,null,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1932.canMerge(trees)));
    }

    @Test
    public void example2() {
        List<TreeNode> trees = List.of(
                TreeNode.buildTreeNode("[5,3,8]"),
                TreeNode.buildTreeNode("[3,2,6]")
        );
        TreeNode expected = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1932.canMerge(trees)));
    }

    @Test
    public void example3() {
        List<TreeNode> trees = List.of(
                TreeNode.buildTreeNode("[5,4]"),
                TreeNode.buildTreeNode("[3]")
        );
        TreeNode expected = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1932.canMerge(trees)));
    }
}