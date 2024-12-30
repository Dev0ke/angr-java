import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution145Tests {
    private final Solution145 solution145 = new Solution145();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,3]");
        List<Integer> expected = List.of(3, 2, 1);
        Assertions.assertEquals(expected, solution145.postorderTraversal(root));
    }
}
