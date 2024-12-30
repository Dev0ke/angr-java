import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP314Tests {
    private final SolutionP314 solutionP314 = new SolutionP314();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[9],[3,15],[20],[7]]");
        Assertions.assertEquals(expected, solutionP314.verticalOrder(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,8,4,0,1,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4],[9],[3,0,1],[8],[7]]");
        Assertions.assertEquals(expected, solutionP314.verticalOrder(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,8,4,0,1,7,null,null,null,2,5]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4],[9,5],[3,0,1],[8,2],[7]]");
        Assertions.assertEquals(expected, solutionP314.verticalOrder(root));
    }
}
