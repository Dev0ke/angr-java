import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP366Tests {
    private final SolutionP366 solutionP366 = new SolutionP366();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,5,3],[2],[1]]");
        Assertions.assertEquals(expected, solutionP366.findLeaves(root));
    }
}
