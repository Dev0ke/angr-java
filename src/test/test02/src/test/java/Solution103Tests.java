import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution103Tests {
    private final Solution103 solution103 = new Solution103();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[3],[20,9],[15,7]]");
        Assertions.assertEquals(expected, solution103.zigzagLevelOrder(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1]]");
        Assertions.assertEquals(expected, solution103.zigzagLevelOrder(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution103.zigzagLevelOrder(root));
    }
}
