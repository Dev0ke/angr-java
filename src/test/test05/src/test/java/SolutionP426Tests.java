import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP426Tests {
    private final SolutionP426 solutionP426 = new SolutionP426();

    @Test
    public void example1() {
        SolutionP426.Node root = new SolutionP426.Node(4);
        root.left = new SolutionP426.Node(2);
        root.right = new SolutionP426.Node(5);
        root.left.left = new SolutionP426.Node(1);
        root.left.right = new SolutionP426.Node(3);

        SolutionP426.Node expected = new SolutionP426.Node(1);
        expected.right = new SolutionP426.Node(2);
        expected.right.right = new SolutionP426.Node(3);
        expected.right.right.right = new SolutionP426.Node(4);
        expected.right.right.right.right = new SolutionP426.Node(5);
        expected.right.right.right.right.right = expected;

        expected.right.left = expected;
        expected.right.right.left = expected.right;
        expected.right.right.right.left = expected.right.right;
        expected.right.right.right.right.left = expected.right.right.right;
        expected.left = expected.right.right.right.right;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP426.treeToDoublyList(root)));
    }

    @Test
    public void example2() {
        SolutionP426.Node root = new SolutionP426.Node(2);
        root.left = new SolutionP426.Node(1);
        root.right = new SolutionP426.Node(3);

        SolutionP426.Node expected = new SolutionP426.Node(1);
        expected.right = new SolutionP426.Node(2);
        expected.right.right = new SolutionP426.Node(3);
        expected.right.right.right = expected;

        expected.right.left = expected;
        expected.right.right.left = expected.right;
        expected.left = expected.right.right;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP426.treeToDoublyList(root)));
    }

    @Test
    public void example3() {
        SolutionP426.Node root = null;
        SolutionP426.Node expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP426.treeToDoublyList(root)));
    }

    @Test
    public void example4() {
        SolutionP426.Node root = new SolutionP426.Node(1);
        SolutionP426.Node expected = new SolutionP426.Node(1);
        expected.left = expected;
        expected.right = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP426.treeToDoublyList(root)));
    }
}
