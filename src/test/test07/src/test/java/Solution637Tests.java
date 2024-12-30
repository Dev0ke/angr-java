import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution637Tests {
    private final Solution637 solution637 = new Solution637();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<Double> expected = List.of(3.0, 14.5, 11.0);
        Assertions.assertEquals(expected, solution637.averageOfLevels(root));
    }
}
