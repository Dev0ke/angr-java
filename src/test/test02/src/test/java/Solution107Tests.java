import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution107Tests {
    private final Solution107 solution107 = new Solution107();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[15,7],[9,20],[3]]");
        Assertions.assertEquals(expected, solution107.levelOrderBottom(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1]]");
        Assertions.assertEquals(expected, solution107.levelOrderBottom(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution107.levelOrderBottom(root));
    }
}
