import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP1469Tests {
    private final SolutionP1469 solutionP1469 = new SolutionP1469();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        List<Integer> expected = new ArrayList<>(List.of(4));
        List<Integer> actual = solutionP1469.getLonelyNodes(root);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[7,1,4,6,null,5,3,null,null,null,null,null,2]");
        List<Integer> expected = new ArrayList<>(List.of(6, 2));
        List<Integer> actual = solutionP1469.getLonelyNodes(root);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]");
        List<Integer> expected = new ArrayList<>(List.of(77, 55, 33, 66, 44, 22));
        List<Integer> actual = solutionP1469.getLonelyNodes(root);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[197]");
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = solutionP1469.getLonelyNodes(root);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[31,null,78,null,28]");
        List<Integer> expected = new ArrayList<>(List.of(78, 28));
        List<Integer> actual = solutionP1469.getLonelyNodes(root);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
