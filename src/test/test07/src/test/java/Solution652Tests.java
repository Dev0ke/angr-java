import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution652Tests {
    private final Solution652 solution652 = new Solution652();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,null,2,4,null,null,4]");
        List<TreeNode> expected = Arrays.asList(TreeNode.buildTreeNode("[2,4]"), TreeNode.buildTreeNode("[4]"));
        List<String> expectedStr = expected.stream().map(TreeNode::tree2String).sorted().toList();
        List<String> actualStr = solution652.findDuplicateSubtrees(root).stream().map(TreeNode::tree2String).sorted().toList();
        Assertions.assertEquals(expectedStr, actualStr);
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,2,3,null,3,null]");
        List<TreeNode> expected = Arrays.asList(TreeNode.buildTreeNode("[2,3]"), TreeNode.buildTreeNode("[3]"));
        List<String> expectedStr = expected.stream().map(TreeNode::tree2String).sorted().toList();
        List<String> actualStr = solution652.findDuplicateSubtrees(root).stream().map(TreeNode::tree2String).sorted().toList();
        Assertions.assertEquals(expectedStr, actualStr);
    }
}
