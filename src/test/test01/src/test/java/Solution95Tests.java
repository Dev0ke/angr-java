import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution95Tests {
    private final Solution95 solution95 = new Solution95();

    @Test
    public void example1() {
        int n = 3;
        List<TreeNode> expected = Arrays.asList(
                TreeNode.buildTreeNode("[1,null,2,null,3]"),
                TreeNode.buildTreeNode("[1,null,3,2]"),
                TreeNode.buildTreeNode("[2,1,3]"),
                TreeNode.buildTreeNode("[3,1,null,null,2]"),
                TreeNode.buildTreeNode("[3,2,null,1]")
        );
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution95.generateTrees(n)));
    }

    @Test
    public void example2() {
        int n = 1;
        List<TreeNode> expected = Arrays.asList(
                TreeNode.buildTreeNode("[1]")
        );
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution95.generateTrees(n)));
    }
}
