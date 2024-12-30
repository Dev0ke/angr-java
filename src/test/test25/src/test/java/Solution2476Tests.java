import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2476Tests {
    private final Solution2476 solution2476 = new Solution2476();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[6,2,13,1,4,9,15,null,null,null,null,null,null,14]");
        List<Integer> queries = List.of(2, 5, 16);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2],[4,6],[15,-1]]");
        Assertions.assertEquals(expected, solution2476.closestNodes(root, queries));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,null,9]");
        List<Integer> queries = List.of(3);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[-1,4]]");
        Assertions.assertEquals(expected, solution2476.closestNodes(root, queries));
    }
}
