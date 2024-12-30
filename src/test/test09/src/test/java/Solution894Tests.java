import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution894Tests {
    private final Solution894 solution894 = new Solution894();

    @Test
    public void example1() {
        int n = 7;
        List<TreeNode> expected = Arrays.asList(
                TreeNode.buildTreeNode("[0,0,0,null,null,0,0,null,null,0,0]"),
                TreeNode.buildTreeNode("[0,0,0,null,null,0,0,0,0]"),
                TreeNode.buildTreeNode("[0,0,0,0,0,0,0]"),
                TreeNode.buildTreeNode("[0,0,0,0,0,null,null,null,null,0,0]"),
                TreeNode.buildTreeNode("[0,0,0,0,0,null,null,0,0]")
        );
        List<String> expectedStr = expected.stream().map(TreeNode::tree2String).toList();
        List<String> actualStr = solution894.allPossibleFBT(n).stream().map(TreeNode::tree2String).toList();
        Assertions.assertEquals(expectedStr, actualStr);
    }

    @Test
    public void example2() {
        int n = 3;
        List<TreeNode> expected = Arrays.asList(
                TreeNode.buildTreeNode("[0,0,0]")
        );
        List<String> expectedStr = expected.stream().map(TreeNode::tree2String).toList();
        List<String> actualStr = solution894.allPossibleFBT(n).stream().map(TreeNode::tree2String).toList();
        Assertions.assertEquals(expectedStr, actualStr);
    }
}
